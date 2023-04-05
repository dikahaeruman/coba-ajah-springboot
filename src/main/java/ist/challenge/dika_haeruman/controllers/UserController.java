package ist.challenge.dika_haeruman.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ist.challenge.dika_haeruman.models.User;
import ist.challenge.dika_haeruman.models.dto.UserDTO;
import ist.challenge.dika_haeruman.services.UserService;
import ist.challenge.dika_haeruman.utils.exception.SamePasswordWithExistingException;
import ist.challenge.dika_haeruman.utils.exception.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users", notes = "Return all users on database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message  = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Data is not found")
    })
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

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateByUserId(@PathVariable long id, @RequestBody UserDTO userDTO) throws Exception {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            String result = userService.updateUserById(id, userDTO);
            map.put("status", 201);
            map.put("message", result);
        } catch (UsernameAlreadyExistException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        } catch (SamePasswordWithExistingException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
