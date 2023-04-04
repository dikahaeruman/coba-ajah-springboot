package ist.challenge.dika_haeruman.services;

import ist.challenge.dika_haeruman.DTO.UserDTO;
import ist.challenge.dika_haeruman.models.RegistrationResponse;
import ist.challenge.dika_haeruman.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    UserService userService;

    public ResponseEntity registUser(UserDTO userDTO) {
        List<User> listUser = userService.getAllUser();

        for(User user: listUser) {
            if(user.getUsername().equals(userDTO.getUsername())) {
                return new ResponseEntity("Username sudah terpakai", HttpStatus.CONFLICT);
            }
        }

        userService.createUser(userDTO);

        return new ResponseEntity("User berhasil dibuat", HttpStatus.CREATED);
    }
}
