package api.tchiiwa.microservice.features.profile.domain.exceptions;

public class ProfileConflictException extends RuntimeException {
    public ProfileConflictException(String message) {
        super(message);
    }
}
