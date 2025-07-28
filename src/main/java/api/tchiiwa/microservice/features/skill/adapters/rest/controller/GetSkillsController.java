package api.tchiiwa.microservice.features.skill.adapters.rest.controller;

import api.tchiiwa.microservice.features.skill.application.dtos.PaginatedSkillsResponseDTO;
import api.tchiiwa.microservice.features.skill.application.dtos.PaginationSkillRequestDTO;
import api.tchiiwa.microservice.features.skill.application.services.SkillServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("skill")
public class GetSkillsController {
    private final SkillServices skillServices;

    @Inject
    public GetSkillsController(SkillServices skillServices) {
        this.skillServices = skillServices;
    }

    @GET
    @Path("all")
    public PaginatedSkillsResponseDTO getSkills(
            @Valid @BeanParam PaginationSkillRequestDTO paginationSkillRequestDTO
    ) {
        return this.skillServices.getAllSkills(paginationSkillRequestDTO);
    }
}