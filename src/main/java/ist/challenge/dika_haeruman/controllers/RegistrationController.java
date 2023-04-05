package ist.challenge.dika_haeruman.controllers;

import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class RegistrationController {
    @Autowired
    private RegistrationService regisrationService;

    @PostMapping("/users")
    public ResponseEntity<?> registUser(@RequestBody UserDTO userDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        try {
            regisrationService.save(userDTO);
            map.put("status", 201);
            map.put("message", "Record is Saved Successfully!");
        } catch (Exception ex) {
            map.clear();
            map.put("status", 409);
            map.put("message", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
