package api.tchiiwa.microservice.features.person.adapters.rest.exeptons;

import api.tchiiwa.microservice.features.person.domain.exeptions.PersonIdNotValidException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class PersonIdNotValidExceptionMapper implements ExceptionMapper<PersonIdNotValidException> {

    @Override
    public Response toResponse(PersonIdNotValidException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponseDTO("PERSON_ID_NOT_VALID", exception.getMessage()))
                .build();
    }
}