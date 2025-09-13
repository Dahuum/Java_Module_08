
package school42.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import school42.spring.service.models.User;
import school42.spring.service.repositories.UsersRepository;
import java.util.UUID;

@Service  
public class UsersServiceImpl implements UsersService {

    @Autowired  
    @Qualifier("usersRepositoryJdbcTemplate")  
    private UsersRepository usersRepository;

    @Override
    public String signUp(String email) {
        String tempPassword = UUID.randomUUID().toString().substring(0, 8);
        
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(tempPassword);
        
        usersRepository.save(newUser);
        
        return tempPassword;
    }
}
