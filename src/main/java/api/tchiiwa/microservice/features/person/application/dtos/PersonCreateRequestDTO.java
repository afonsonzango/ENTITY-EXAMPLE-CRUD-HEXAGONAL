package api.tchiiwa.microservice.features.person.application.dtos;

import api.tchiiwa.microservice.features.person.domain.enums.GenderEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonCreateRequestDTO {
    @NotNull(message = "Gender cannot be null")
    private GenderEnum gender;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Birth date cannot be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birth date must be in the format yyyy-MM-dd")
    private String birthDate;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    public GenderEnum getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Long getUserId() {
        return userId;
    }
}