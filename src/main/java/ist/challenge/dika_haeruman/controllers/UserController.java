package ist.challenge.dika_haeruman.controllers;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUser() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<User> userList = userService.getUser();

        if(!userList.isEmpty()) {
            map.put("status", HttpStatus.OK.value());
            map.put("data", userList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        map.clear();
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("message", "Data is not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
