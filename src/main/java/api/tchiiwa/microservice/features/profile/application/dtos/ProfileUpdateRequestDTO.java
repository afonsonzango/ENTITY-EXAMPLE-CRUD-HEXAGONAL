package api.tchiiwa.microservice.features.profile.application.dtos;

import jakarta.validation.constraints.Size;

public class ProfileUpdateRequestDTO {
    @Size(min = 2, max = 100, message = "Display name must be between 2 and 100 characters")
    private String displayName;

    @Size(min = 10, max = 2000, message = "Bio must be between 10 and 2000 characters")
    private String bio;

    private Boolean isPublic;

    public String getDisplayName() {
        return displayName;
    }

    public String getBio() {
        return bio;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }
}