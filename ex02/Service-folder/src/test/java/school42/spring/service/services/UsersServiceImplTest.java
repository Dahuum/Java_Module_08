package school42.spring.service.services;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school42.spring.service.config.TestApplicationConfig;

import static org.junit.jupiter.api.Assertions.*;

public class UsersServiceImplTest {

    @Test
    public void testSignUp() {
        // Create test context with in-memory database
        try (AnnotationConfigApplicationContext context = 
             new AnnotationConfigApplicationContext(TestApplicationConfig.class)) {
            
            UsersService usersService = context.getBean(UsersService.class);
            
            String tempPassword = usersService.signUp("im7waden");
            
            assertNotNull(tempPassword);
            assertFalse(tempPassword.isEmpty());
            
            System.out.println("Test passed! Temporary password: " + tempPassword);
        }
    }
}