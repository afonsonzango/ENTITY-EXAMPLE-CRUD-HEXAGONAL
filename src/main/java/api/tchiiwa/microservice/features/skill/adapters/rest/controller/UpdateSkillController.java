package api.tchiiwa.microservice.features.skill.adapters.rest.controller;

import api.tchiiwa.microservice.features.skill.application.dtos.SkillResponseDTO;
import api.tchiiwa.microservice.features.skill.application.dtos.SkillUpdateRequestDTO;
import api.tchiiwa.microservice.features.skill.application.services.SkillServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.apache.camel.Body;

@Path("skill")
public class UpdateSkillController {
    private final SkillServices skillServices;

    @Inject
    public UpdateSkillController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }

    @PUT
    @Path("update/{id}")
    public SkillResponseDTO updateSkill(
            @PathParam("id") Long id,
            @Valid @Body SkillUpdateRequestDTO skillUpdateRequestDTO
    ) {
        return this.skillServices.updateSkill(id, skillUpdateRequestDTO);
    }
}