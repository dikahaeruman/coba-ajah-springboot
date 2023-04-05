package ist.challenge.dika_haeruman.services;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.utils.exception.UserIsAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    UserService userService;

    public void save(UserDTO userDTO) throws Exception {
        List<User> listUser = userService.getUser();

        for(User user: listUser) {
            if(user.getUsername().equals(userDTO.getUsername())) {
                throw new UserIsAlreadyRegisteredException();
            }
        }

        userService.saveUser(userDTO);
    }
}
