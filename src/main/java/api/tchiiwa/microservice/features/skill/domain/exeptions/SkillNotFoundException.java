package api.tchiiwa.microservice.features.skill.domain.exeptions;

public class SkillNotFoundException extends RuntimeException {
    public SkillNotFoundException(String message) {
        super(message);
    }
}