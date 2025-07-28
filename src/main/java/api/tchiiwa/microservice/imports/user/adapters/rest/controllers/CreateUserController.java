package api.tchiiwa.microservice.imports.user.adapters.rest.controllers;

import api.tchiiwa.microservice.imports.user.application.dtos.UserCreateRequestDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.UserResponseDTO;
import api.tchiiwa.microservice.imports.user.application.services.UserServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.apache.camel.Body;

@Path("user")
public class CreateUserController {
    private final UserServices userServices;

    @Inject
    public CreateUserController (UserServices userServices) {
        this.userServices = userServices;
    }

    @POST
    @Path("create")
    public UserResponseDTO createUser(
            @Valid @Body() UserCreateRequestDTO userCreateRequestDTO
    ) {
        return this.userServices.createUser(userCreateRequestDTO);
    }
}