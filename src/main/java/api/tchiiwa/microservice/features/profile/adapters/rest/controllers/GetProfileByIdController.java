package api.tchiiwa.microservice.features.profile.adapters.rest.controllers;

import api.tchiiwa.microservice.features.profile.application.dtos.ProfileResponseDTO;
import api.tchiiwa.microservice.features.profile.application.services.ProfileServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("profile")
public class GetProfileByIdController {
    private final ProfileServices profileServices;

    @Inject
    public GetProfileByIdController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @GET
    @Path("get/{id}")
    public ProfileResponseDTO getProfileById(
            @PathParam("id") String id
    ) {
        return this.profileServices.getProfileById(id);
    }
}
