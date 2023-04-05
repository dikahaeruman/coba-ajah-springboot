package ist.challenge.dika_haeruman.utils.exception;

public class UsernameAlreadyExistException extends Exception {
    public UsernameAlreadyExistException() {
        super("Username sudah terpakai");
    }
}