package api.tchiiwa.microservice.features.person.application.dtos;

import api.tchiiwa.microservice.features.person.domain.enums.GenderEnum;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonUpdateRequestDTO {
    private GenderEnum gender;

    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birth date must be in the format yyyy-MM-dd")
    private String birthDate;

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
}

