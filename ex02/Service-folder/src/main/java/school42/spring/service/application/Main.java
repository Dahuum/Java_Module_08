
package school42.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school42.spring.service.config.ApplicationConfig;
import school42.spring.service.services.UsersService;
import school42.spring.service.repositories.UsersRepository;

public class Main {
    public static void main(String[] args) {
        
        try (AnnotationConfigApplicationContext context = 
             new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            
            UsersService usersService = context.getBean(UsersService.class);
            
            System.out.println("=== Testing Service Layer ===");
            String tempPassword = usersService.signUp("ayeh@example.com");
            System.out.println("User registered with temporary password: " + tempPassword);
            
            System.out.println("\n=== Testing Repository Layer ===");
            UsersRepository repository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
            System.out.println("All users:");
            System.out.println(repository.findAll());
            
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }
}
