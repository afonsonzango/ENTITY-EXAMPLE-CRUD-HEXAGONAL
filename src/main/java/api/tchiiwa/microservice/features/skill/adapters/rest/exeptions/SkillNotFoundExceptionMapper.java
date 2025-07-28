package api.tchiiwa.microservice.features.skill.adapters.rest.exeptions;

import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillNotFoundException;
import api.tchiiwa.microservice.root.shared.dtos.ErrorResponseDTO;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class SkillNotFoundExceptionMapper implements ExceptionMapper<SkillNotFoundException> {
    @Override
    public Response toResponse(SkillNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponseDTO("SKILL_NOT_FOUND", exception.getMessage()))
                .build();
    }
}
