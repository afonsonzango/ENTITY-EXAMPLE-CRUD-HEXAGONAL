package api.tchiiwa.microservice.features.person.domain.exeptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
