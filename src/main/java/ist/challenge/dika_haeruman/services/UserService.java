package ist.challenge.dika_haeruman.services;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.repository.UserRepository;
import ist.challenge.dika_haeruman.utils.exception.SamePasswordWithExistingException;
import ist.challenge.dika_haeruman.utils.exception.UserIsAlreadyRegisteredException;
import ist.challenge.dika_haeruman.utils.exception.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String updateUserById(long id, UserDTO userDTO) throws Exception {
        List<User> listUser =  this.getUser();
        for(User user: listUser) {
            if(user.getUsername().equals(userDTO.getUsername())) {
                throw new UsernameAlreadyExistException();
            }
        }
        User existingUser = userRepository.findById(id);

        if(userDTO.getPassword().equals(existingUser.getPassword())) {
            throw new SamePasswordWithExistingException();
        }

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        userRepository.save(existingUser);
        return "Sukses update user";
    }
}
