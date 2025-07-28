package api.tchiiwa.microservice.features.profile.adapters.rest.controllers;

import api.tchiiwa.microservice.features.profile.application.dtos.PaginatedProfilesResponseDTO;
import api.tchiiwa.microservice.features.profile.application.dtos.PaginationProfileRequestDTO;
import api.tchiiwa.microservice.features.profile.application.services.ProfileServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("profile")
public class GetProfilesController {
    private final ProfileServices profileServices;

    @Inject
    public GetProfilesController(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }

    @GET
    @Path("all")
    public PaginatedProfilesResponseDTO getProfiles(
            @Valid @BeanParam PaginationProfileRequestDTO paginationProfileRequestDTO
    ) {
        return this.profileServices.getAllProfiles(paginationProfileRequestDTO);
    }
}