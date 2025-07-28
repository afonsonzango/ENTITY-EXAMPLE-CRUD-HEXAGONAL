package api.tchiiwa.microservice.features.skill.adapters.rest.controller;

import api.tchiiwa.microservice.features.skill.application.services.SkillServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("skill")
public class DeleteSkillByIdController {
    private final SkillServices skillServices;

    @Inject
    public DeleteSkillByIdController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteSkillById(
            @PathParam("id") Long id
    ) {
        this.skillServices.deleteSkill(id);
    }
}