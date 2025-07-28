package api.tchiiwa.microservice.features.profile.domain.exceptions;

public class ProfileIdNotValidException extends RuntimeException {
    public ProfileIdNotValidException(String message) {
        super(message);
    }
}
