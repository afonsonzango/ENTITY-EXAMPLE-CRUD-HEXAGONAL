package api.tchiiwa.microservice.features.profile.adapters.rest.exceptions;

import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileNotFoundException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ProfileNotFoundExceptionMapper implements ExceptionMapper<ProfileNotFoundException> {
    @Override
    public Response toResponse(ProfileNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponseDTO("PROFILE_NOT_FOUND", exception.getMessage()))
                .build();
    }
}