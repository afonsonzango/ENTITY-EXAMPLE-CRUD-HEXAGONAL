package api.tchiiwa.microservice.features.skill.adapters.rest.exeptions;

import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillIdNotValidException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class SkillIdNotValidExceptionMapper implements ExceptionMapper<SkillIdNotValidException> {
    @Override
    public Response toResponse(SkillIdNotValidException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponseDTO("SKILL_ID_NOT_VALID", exception.getMessage()))
                .build();
    }
}