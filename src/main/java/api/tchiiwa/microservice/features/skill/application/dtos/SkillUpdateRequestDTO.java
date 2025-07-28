package api.tchiiwa.microservice.features.skill.application.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class SkillUpdateRequestDTO {
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 5, message = "Level cannot exceed 5")
    private Integer level;

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }
}
