package api.tchiiwa.microservice.features.person.domain.exeptions;

public class PersonIdNotValidException extends RuntimeException {
    public PersonIdNotValidException(String message) {
        super(message);
    }
}
