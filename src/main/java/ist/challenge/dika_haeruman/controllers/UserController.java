package ist.challenge.dika_haeruman.controllers;

import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public @ResponseBody List<User> listAll() {
       return userService.getAllUser();
    }
}
