package api.tchiiwa.microservice.features.person.domain.exeptions;

public class PersonConflictException extends RuntimeException {
    public PersonConflictException(String message) {
        super(message);
    }
}
