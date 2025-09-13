package school42.spring.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("school42.spring.service")
public class ApplicationConfig {

    @Bean
    public DataSource driverManagerDataSource(@Value("${db.url}") String url,
                                             @Value("${db.user}") String user,
                                             @Value("${db.password}") String password,
                                             @Value("${db.driver.name}") String driverName) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        return dataSource;
    }
    
    @Bean
    public DataSource hikariDataSource(@Value("${db.url}") String url,
                                     @Value("${db.user}") String user,
                                     @Value("${db.password}") String password,
                                     @Value("${db.driver.name}") String driverName) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        return dataSource;
    }
}
