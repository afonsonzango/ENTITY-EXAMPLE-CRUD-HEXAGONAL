package api.tchiiwa.microservice.features.profile.application.dtos;

import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;

import java.util.List;

public class PaginatedProfilesResponseDTO {
    private PaginationResponseDTO paginationResponseDTO;
    private List<ProfileResponseDTO> profiles;

    public PaginatedProfilesResponseDTO() {}

    public PaginationResponseDTO getPaginationResponseDTO() {
        return paginationResponseDTO;
    }

    public void setPaginationResponseDTO(PaginationResponseDTO paginationResponseDTO) {
        this.paginationResponseDTO = paginationResponseDTO;
    }

    public List<ProfileResponseDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileResponseDTO> profiles) {
        this.profiles = profiles;
    }
}