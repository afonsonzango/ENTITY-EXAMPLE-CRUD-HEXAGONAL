package api.tchiiwa.microservice.features.skill.application.dtos;

import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;

import java.util.List;

public class PaginatedSkillsResponseDTO {
    private PaginationResponseDTO paginationResponseDTO;
    private List<SkillResponseDTO> skills;

    public PaginationResponseDTO getPaginationResponseDTO() {
        return paginationResponseDTO;
    }

    public void setPaginationResponseDTO(PaginationResponseDTO paginationResponseDTO) {
        this.paginationResponseDTO = paginationResponseDTO;
    }

    public List<SkillResponseDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillResponseDTO> skills) {
        this.skills = skills;
    }
}
