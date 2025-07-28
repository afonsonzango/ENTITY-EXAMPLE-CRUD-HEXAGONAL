package api.tchiiwa.microservice.features.person.application.services;

import api.tchiiwa.microservice.features.person.application.dtos.*;
import api.tchiiwa.microservice.features.person.application.ports.in.PersonServiceInPort;
import api.tchiiwa.microservice.features.person.domain.exeptions.PersonConflictException;
import api.tchiiwa.microservice.features.person.domain.exeptions.PersonIdNotValidException;
import api.tchiiwa.microservice.features.person.domain.exeptions.PersonNotFoundException;
import api.tchiiwa.microservice.features.person.domain.mappers.PersonMapper;
import api.tchiiwa.microservice.features.person.domain.models.PersonModel;
import api.tchiiwa.microservice.features.person.infrastructure.repository.PersonRepository;
import api.tchiiwa.microservice.imports.user.domain.exeptions.UserNotFoundException;
import api.tchiiwa.microservice.imports.user.domain.models.UserModel;
import api.tchiiwa.microservice.imports.user.infrastructure.repository.UserRepository;
import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PersonServices implements PersonServiceInPort {
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PersonMapper personMapper;

    @Inject
    public PersonServices(PersonRepository personRepository, UserRepository userRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.personMapper = personMapper;
    }

    @Transactional
    @Override
    public PaginatedPersonsResponseDTO getAllPersons(PaginationPersonRequestDTO dto) {
        PaginatedPersonsResponseDTO response = new PaginatedPersonsResponseDTO();

        long allPersons = this.personRepository.findAll().size();

        // Fetch all persons for total count (no pagination)
        List<PersonModel> filteredList = this.personRepository.findAll(
                0,
                Integer.MAX_VALUE
        );

        // Fetch paginated persons
        List<PersonResponseDTO> persons = this.personRepository
                .findAll(dto.getPage(), dto.getSize())
                .stream()
                .map(personMapper::toResponseDTO)
                .toList();

        // Calculate pagination details
        int totalItems = filteredList.size();
        int totalPages = (int) Math.ceil((double) totalItems / dto.getSize());
        Integer nextPage = (dto.getPage() + 1 >= totalPages) ? null : dto.getPage() + 1;

        // Build pagination response
        PaginationResponseDTO pagination = new PaginationResponseDTO();
        pagination.setCurrentPage(dto.getPage());
        pagination.setTotalItems(totalItems);
        pagination.setTotalCurrentItems(persons.size());
        pagination.setTotalPages(totalPages);
        pagination.setNextPage(nextPage);
        pagination.setAllItems(allPersons);

        // Set response data
        response.setPersons(persons);
        response.setPaginationResponseDTO(pagination);

        return response;
    }

    @Override
    public PersonResponseDTO getPersonById(String id) {
        try {
            UUID uuid = UUID.fromString(id);

            return this.personRepository.findByUuid(uuid)
                    .map(personMapper::toResponseDTO)
                    .orElseThrow(() -> new PersonNotFoundException("Person not found with uuid " + uuid));
        } catch (IllegalArgumentException e) {
            try {
                Long longId = Long.parseLong(id);
                return this.personRepository.findById(longId)
                        .map(personMapper::toResponseDTO)
                        .orElseThrow(() -> new PersonNotFoundException("Person not found with id " + longId));
            } catch (NumberFormatException ex) {
                throw new PersonIdNotValidException("Person id is not valid");
            }
        }
    }

    @Transactional
    @Override
    public PersonResponseDTO createPerson(PersonCreateRequestDTO personCreateRequestDTO) {
        UserModel user = this.userRepository.findById(personCreateRequestDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + personCreateRequestDTO.getUserId()));

        if (user.getPerson() != null) {
            throw new PersonConflictException("Already exists person with user id " + personCreateRequestDTO.getUserId());
        }

        PersonModel personModel = new PersonModel();

        personModel.setBirthDate(personCreateRequestDTO.getBirthDate());
        personModel.setFirstName(personCreateRequestDTO.getFirstName());
        personModel.setLastName(personCreateRequestDTO.getLastName());
        personModel.setGender(personCreateRequestDTO.getGender());
        personModel.setUser(user);

        return this.personMapper.toResponseDTO(this.personRepository.create(personModel));
    }

    @Transactional
    @Override
    public PersonResponseDTO updatePerson(Long id, PersonUpdateRequestDTO dto) {
        PersonModel model = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id " + id));

        if (dto.getBirthDate() != null) model.setBirthDate(dto.getBirthDate());
        if (dto.getFirstName() != null) model.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) model.setLastName(dto.getLastName());
        if (dto.getGender() != null) model.setGender(dto.getGender());

        return this.personMapper.toResponseDTO(this.personRepository.update(model));
    }

    @Transactional
    @Override
    public void deletePerson(Long id) {
        this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id " + id));

        this.personRepository.deleteById(id);
    }
}