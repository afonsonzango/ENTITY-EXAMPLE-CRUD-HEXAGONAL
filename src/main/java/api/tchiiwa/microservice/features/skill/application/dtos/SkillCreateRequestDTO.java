package api.tchiiwa.microservice.features.skill.application.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SkillCreateRequestDTO {
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Level cannot be null")
    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 5, message = "Level cannot exceed 5")
    private Integer level;

    @NotNull(message = "Person ID cannot be null")
    private Long personId;

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Long getPersonId() {
        return personId;
    }
}
