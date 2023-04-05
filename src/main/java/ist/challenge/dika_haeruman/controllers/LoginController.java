package ist.challenge.dika_haeruman.controllers;

import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.services.LoginService;
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
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        if(userDTO.getUsername().isEmpty() || userDTO.getPassword().isEmpty()) {
            map.put("status", 400);
            map.put("message", "Username dan / atau password kosong");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        try {
            String loginResult = loginService.login(userDTO);
            map.put("status", 200);
            map.put("message", loginResult);
        } catch (Exception ex) {
            map.put("status", 401);
            map.put("message", ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
