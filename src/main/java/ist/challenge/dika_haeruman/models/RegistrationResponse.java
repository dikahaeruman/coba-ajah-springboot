package ist.challenge.dika_haeruman.models;

public class RegistrationResponse {
    public RegistrationResponse(String message, String status, int code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    private String message;
    private String status;
    private int code;
}
