package ist.challenge.dika_haeruman.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User Already Registered")
public class UserIsAlreadyRegisteredException extends Exception {
    public UserIsAlreadyRegisteredException() {
        super("User is already registered!");
    }
}
