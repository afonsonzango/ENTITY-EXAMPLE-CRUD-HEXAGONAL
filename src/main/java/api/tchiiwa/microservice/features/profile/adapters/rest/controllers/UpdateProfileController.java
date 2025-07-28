package api.tchiiwa.microservice.features.profile.adapters.rest.controllers;

import api.tchiiwa.microservice.features.profile.application.dtos.ProfileResponseDTO;
import api.tchiiwa.microservice.features.profile.application.dtos.ProfileUpdateRequestDTO;
import api.tchiiwa.microservice.features.profile.application.services.ProfileServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.apache.camel.Body;

@Path("profile")
public class UpdateProfileController {
    private final ProfileServices profileServices;

    @Inject
    public UpdateProfileController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @PUT
    @Path("update/{id}")
    public ProfileResponseDTO updateProfile(
            @PathParam("id") Long id,
            @Valid @Body ProfileUpdateRequestDTO profileUpdateRequestDTO
    ) {
        return this.profileServices.updateProfile(id, profileUpdateRequestDTO);
    }
}