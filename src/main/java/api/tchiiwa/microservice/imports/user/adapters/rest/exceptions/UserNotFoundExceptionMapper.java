package api.tchiiwa.microservice.imports.user.adapters.rest.exceptions;

import api.tchiiwa.microservice.imports.user.domain.exeptions.UserNotFoundException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponseDTO("USER_NOT_FOUND", exception.getMessage()))
                .build();
    }
}