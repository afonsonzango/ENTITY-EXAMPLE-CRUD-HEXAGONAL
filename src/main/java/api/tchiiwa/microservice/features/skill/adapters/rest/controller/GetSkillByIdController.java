package api.tchiiwa.microservice.features.skill.adapters.rest.controller;

import api.tchiiwa.microservice.features.skill.application.dtos.SkillResponseDTO;
import api.tchiiwa.microservice.features.skill.application.services.SkillServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("skill")
public class GetSkillByIdController {
    private final SkillServices skillServices;

    @Inject
    public GetSkillByIdController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }

    @GET
    @Path("get/{id}")
    public SkillResponseDTO getSkillById(
            @PathParam("id") String id
    ) {
        return this.skillServices.getSkillById(id);
    }
}