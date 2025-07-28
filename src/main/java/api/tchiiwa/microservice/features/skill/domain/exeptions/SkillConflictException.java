package api.tchiiwa.microservice.features.skill.domain.exeptions;

public class SkillConflictException extends RuntimeException {
    public SkillConflictException(String message) {
        super(message);
    }
}