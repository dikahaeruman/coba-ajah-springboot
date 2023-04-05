package ist.challenge.dika_haeruman.services;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.utils.exception.InvalidUsernameOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private UserService userService;

    public String login(UserDTO userDTO) throws Exception {
        List<User> listUser = userService.getUser();
        for(User user: listUser) {
            if(user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())) {
                return "Sukses login";
            }
        }

        throw new InvalidUsernameOrPasswordException();
    }
}
