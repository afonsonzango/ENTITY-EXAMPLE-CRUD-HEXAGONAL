package api.tchiiwa.microservice.features.person.application.dtos;

import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;

import java.util.List;

public class PaginatedPersonsResponseDTO {
    private PaginationResponseDTO paginationResponseDTO;
    private List<PersonResponseDTO> persons;

    public PaginatedPersonsResponseDTO() {
    }

    public PaginatedPersonsResponseDTO(PaginationResponseDTO paginationResponseDTO, List<PersonResponseDTO> persons) {
        this.paginationResponseDTO = paginationResponseDTO;
        this.persons = persons;
    }

    public PaginationResponseDTO getPaginationResponseDTO() {
        return paginationResponseDTO;
    }

    public void setPaginationResponseDTO(PaginationResponseDTO paginationResponseDTO) {
        this.paginationResponseDTO = paginationResponseDTO;
    }

    public List<PersonResponseDTO> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonResponseDTO> persons) {
        this.persons = persons;
    }
}