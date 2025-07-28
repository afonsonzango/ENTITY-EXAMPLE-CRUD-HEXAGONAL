package api.tchiiwa.microservice.imports.user.adapters.rest.controllers;

import api.tchiiwa.microservice.imports.user.application.dtos.UserResponseDTO;
import api.tchiiwa.microservice.imports.user.application.services.UserServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("user")
public class GetUserByIdController {
    private final UserServices userService;

    @Inject
    public GetUserByIdController(UserServices userService) {
        this.userService = userService;
    }

    @GET
    @Path("get/{id}")
    public UserResponseDTO createUser(
            @PathParam("id") String id
    ) {
        return this.userService.getUserById(id);
    }
}