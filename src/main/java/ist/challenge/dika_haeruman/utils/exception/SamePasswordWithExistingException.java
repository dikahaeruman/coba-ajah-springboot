package ist.challenge.dika_haeruman.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "New Password Same With Existing")
public class SamePasswordWithExistingException extends Exception {
    public SamePasswordWithExistingException() {
        super("Password tidak boleh sama dengan password sebelumnya");
    }
}
