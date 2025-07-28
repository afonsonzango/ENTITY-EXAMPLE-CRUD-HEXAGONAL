package api.tchiiwa.microservice.features.profile.adapters.rest.exceptions;

import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileIdNotValidException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ProfileIdNotValidExceptionMapper implements ExceptionMapper<ProfileIdNotValidException> {
    @Override
    public Response toResponse(ProfileIdNotValidException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponseDTO("PROFILE_ID_NOT_VALID", exception.getMessage()))
                .build();
    }
}