package api.tchiiwa.microservice.imports.user.adapters.rest.controllers;

import api.tchiiwa.microservice.imports.user.application.services.UserServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("user")
public class DeleteUserByIdController {
    private final UserServices userService;

    @Inject
    public DeleteUserByIdController(UserServices userService) {
        this.userService = userService;
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteUser(
            @PathParam("id") Long id
    ) {
        this.userService.deleteUser(id);
    }
}