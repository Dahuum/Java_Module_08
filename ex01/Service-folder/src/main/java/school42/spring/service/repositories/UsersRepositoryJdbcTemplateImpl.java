package school42.spring.service.repositories;

import school42.spring.service.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getLong("id"), rs.getString("email"));
        }
    };

    @Override
    public User findById(Long id) {
        String sql = "SELECT id, email FROM users WHERE id = ?";
        List<User> users = jdbcTemplate.query(sql, userRowMapper, id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, email FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public void save(User entity) {
        String sql = "INSERT INTO users (email) VALUES (?)";
        jdbcTemplate.update(sql, entity.getEmail());
    }

    @Override
    public void update(User entity) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        jdbcTemplate.update(sql, entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT id, email FROM users WHERE email = ?";
        List<User> users = jdbcTemplate.query(sql, userRowMapper, email);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }
}