package api.tchiiwa.microservice.imports.user.adapters.rest.controllers;

import api.tchiiwa.microservice.imports.user.application.dtos.PaginatedUsersResponseDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.PaginationUserRequestDTO;
import api.tchiiwa.microservice.imports.user.application.services.UserServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("user")
public class GetUsersController {
    private final UserServices userService;

    @Inject
    public GetUsersController (UserServices userService) {
        this.userService = userService;
    }

    @GET
    @Path("all")
    public PaginatedUsersResponseDTO createUser(
            @Valid @BeanParam PaginationUserRequestDTO paginationUserRequestDTO
    ) {
        return this.userService.getAllUsers(paginationUserRequestDTO);
    }
}