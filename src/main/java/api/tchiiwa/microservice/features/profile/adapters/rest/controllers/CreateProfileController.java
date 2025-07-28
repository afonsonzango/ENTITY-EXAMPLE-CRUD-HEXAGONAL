package api.tchiiwa.microservice.features.profile.adapters.rest.controllers;

import api.tchiiwa.microservice.features.profile.application.dtos.ProfileCreateRequestDTO;
import api.tchiiwa.microservice.features.profile.application.dtos.ProfileResponseDTO;
import api.tchiiwa.microservice.features.profile.application.services.ProfileServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.apache.camel.Body;

@Path("profile")
public class CreateProfileController {
    private final ProfileServices profileServices;

    @Inject
    public CreateProfileController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @POST
    @Path("create")
    public ProfileResponseDTO createProfile(
            @Valid @Body ProfileCreateRequestDTO profileCreateRequestDTO
    ) {
        return this.profileServices.createProfile(profileCreateRequestDTO);
    }
}