package api.tchiiwa.microservice.features.skill.adapters.rest.exeptions;

import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillConflictException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class SkillConflictExceptionMapper implements ExceptionMapper<SkillConflictException> {
    @Override
    public Response toResponse(SkillConflictException exception) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO("SKILL_CONFLICT", exception.getMessage()))
                .build();
    }
}