package api.tchiiwa.microservice.features.profile.adapters.rest.controllers;

import api.tchiiwa.microservice.features.profile.application.services.ProfileServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("profile")
public class DeleteProfileByIdController {
    private final ProfileServices profileServices;

    @Inject
    public DeleteProfileByIdController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteProfileById(
            @PathParam("id") Long id
    ) {
        this.profileServices.deleteProfile(id);
    }
}