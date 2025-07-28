package api.tchiiwa.microservice.features.skill.adapters.rest.controller;

import api.tchiiwa.microservice.features.skill.application.dtos.SkillCreateRequestDTO;
import api.tchiiwa.microservice.features.skill.application.dtos.SkillResponseDTO;
import api.tchiiwa.microservice.features.skill.application.services.SkillServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.apache.camel.Body;

@Path("skill")
public class CreateSkillController {
    private final SkillServices skillServices;

    @Inject
    public CreateSkillController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }

    @POST
    @Path("create")
    public SkillResponseDTO createSkill(
            @Valid @Body() SkillCreateRequestDTO skillCreateRequestDTO
    ) {
        return this.skillServices.createSkill(skillCreateRequestDTO);
    }
}