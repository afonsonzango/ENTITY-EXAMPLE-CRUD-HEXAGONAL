package api.tchiiwa.microservice.imports.user.application.dtos;

import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;

import java.util.List;

public class PaginatedUsersResponseDTO {
    private PaginationResponseDTO paginationResponseDTO;
    private List<UserResponseDTO> users;

    public PaginatedUsersResponseDTO() {
    }

    public PaginatedUsersResponseDTO(PaginationResponseDTO paginationResponseDTO, List<UserResponseDTO> users) {
        this.paginationResponseDTO = paginationResponseDTO;
        this.users = users;
    }

    public PaginationResponseDTO getPaginationResponseDTO() {
        return paginationResponseDTO;
    }

    public void setPaginationResponseDTO(PaginationResponseDTO paginationResponseDTO) {
        this.paginationResponseDTO = paginationResponseDTO;
    }

    public List<UserResponseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponseDTO> users) {
        this.users = users;
    }
}