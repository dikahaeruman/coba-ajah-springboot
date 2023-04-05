package ist.challenge.dika_haeruman.utils.exception;

public class UserIsAlreadyRegisteredException extends Exception {
    public UserIsAlreadyRegisteredException() {
        super("User is already registered!");
    }
}
