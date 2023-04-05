package ist.challenge.dika_haeruman.utils.exception;

public class InvalidUsernameOrPasswordException extends Exception {
    public InvalidUsernameOrPasswordException() {
        super("Username dan / atau password salah");
    }
}
