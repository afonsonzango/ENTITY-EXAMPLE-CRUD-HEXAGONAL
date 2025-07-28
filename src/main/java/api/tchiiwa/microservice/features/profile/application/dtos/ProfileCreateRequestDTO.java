package api.tchiiwa.microservice.features.profile.application.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProfileCreateRequestDTO {
    @NotNull(message = "Display name cannot be null")
    @Size(min = 2, max = 100, message = "Display name must be between 2 and 100 characters")
    private String displayName;

    @NotNull(message = "Bio cannot be null")
    @Size(min = 10, max = 2000, message = "Bio must be between 10 and 2000 characters")
    private String bio;

    @NotNull(message = "Is public cannot be null")
    private Boolean isPublic;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    public String getDisplayName() {
        return displayName;
    }

    public String getBio() {
        return bio;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public Long getUserId() {
        return userId;
    }
}