package school42.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school42.spring.service.repositories.UsersRepository;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        
        try {
            UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
            System.out.println(usersRepository.findAll());
            
            usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
            System.out.println(usersRepository.findAll());
            
        } finally {
            context.close();
        }
    }
}
