package api.tchiiwa.microservice.features.skill.application.ports.in;

import api.tchiiwa.microservice.features.skill.application.dtos.*;

public interface SkillServiceInPort {
    PaginatedSkillsResponseDTO getAllSkills(PaginationSkillRequestDTO paginationSkillRequestDTO);

    SkillResponseDTO getSkillById(String id);

    SkillResponseDTO createSkill(SkillCreateRequestDTO skillCreateRequestDTO);

    SkillResponseDTO updateSkill(Long id, SkillUpdateRequestDTO skillUpdateRequestDTO);

    void deleteSkill(Long id);
}