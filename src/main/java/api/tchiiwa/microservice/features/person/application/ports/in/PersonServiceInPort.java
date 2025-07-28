package api.tchiiwa.microservice.features.person.application.ports.in;

import api.tchiiwa.microservice.features.person.application.dtos.*;

public interface PersonServiceInPort {
    PaginatedPersonsResponseDTO getAllPersons(PaginationPersonRequestDTO dto);

    PersonResponseDTO getPersonById(String id);

    PersonResponseDTO createPerson(PersonCreateRequestDTO personCreateRequestDTO);

    PersonResponseDTO updatePerson(Long id, PersonUpdateRequestDTO personUpdateRequestDTO);

    void deletePerson(Long id);
}