package api.tchiiwa.microservice.features.person.adapters.rest.exeptons;

import api.tchiiwa.microservice.features.person.domain.exeptions.PersonConflictException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class PersonConflictExceptionMapper implements ExceptionMapper<PersonConflictException> {

    @Override
    public Response toResponse(PersonConflictException exception) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO("PERSON_CONFLICT", exception.getMessage()))
                .build();
    }
}