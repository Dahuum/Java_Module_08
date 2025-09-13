package school42.spring.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("school42.spring.service")
public class TestApplicationConfig {

    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDataSource());
        
        jdbcTemplate.execute(
            "CREATE TABLE users (" +
            "id BIGINT IDENTITY PRIMARY KEY, " +
            "email VARCHAR(255) NOT NULL, " +
            "password VARCHAR(255)" +
            ")"
        );
        
        return jdbcTemplate;
    }
}