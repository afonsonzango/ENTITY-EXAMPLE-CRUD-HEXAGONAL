package api.tchiiwa.microservice.features.skill.domain.exeptions;

public class SkillIdNotValidException extends RuntimeException {
    public SkillIdNotValidException(String message) {
        super(message);
    }
}
