package api.tchiiwa.microservice.features.profile.adapters.rest.exceptions;

import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileConflictException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ProfileConflictExceptionMapper implements ExceptionMapper<ProfileConflictException> {
    @Override
    public Response toResponse(ProfileConflictException exception) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO("PROFILE_CONFLICT", exception.getMessage()))
                .build();
    }
}