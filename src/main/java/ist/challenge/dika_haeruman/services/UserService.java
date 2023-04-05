package ist.challenge.dika_haeruman.services;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getUser(){
        return userRepository.findAll();
    }

    public void saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(),userDTO.getPassword());
        userRepository.save(user);
    }
}
