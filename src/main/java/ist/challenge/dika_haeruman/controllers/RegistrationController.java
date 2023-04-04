package ist.challenge.dika_haeruman.controllers;

import ist.challenge.dika_haeruman.DTO.UserDTO;
import ist.challenge.dika_haeruman.models.RegistrationResponse;
import ist.challenge.dika_haeruman.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService regisrationService;

    @PostMapping("/user")
    public ResponseEntity registUser(@RequestBody UserDTO userDTO) {
        return regisrationService.registUser(userDTO);
    }
}
