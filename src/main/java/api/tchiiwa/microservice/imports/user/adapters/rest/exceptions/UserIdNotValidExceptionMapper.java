package api.tchiiwa.microservice.imports.user.adapters.rest.exceptions;

import api.tchiiwa.microservice.imports.user.domain.exeptions.UserIdNotValidException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class UserIdNotValidExceptionMapper implements ExceptionMapper<UserIdNotValidException> {

    @Override
    public Response toResponse(UserIdNotValidException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponseDTO("USER_ID_NOT_VALID", exception.getMessage()))
                .build();
    }
}