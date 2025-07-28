package api.tchiiwa.microservice.features.skill.application.services;

import api.tchiiwa.microservice.features.person.domain.exeptions.PersonNotFoundException;
import api.tchiiwa.microservice.features.person.domain.models.PersonModel;
import api.tchiiwa.microservice.features.person.infrastructure.repository.PersonRepository;
import api.tchiiwa.microservice.features.skill.application.dtos.*;
import api.tchiiwa.microservice.features.skill.application.ports.in.SkillServiceInPort;
import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillConflictException;
import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillIdNotValidException;
import api.tchiiwa.microservice.features.skill.domain.exeptions.SkillNotFoundException;
import api.tchiiwa.microservice.features.skill.domain.mappers.SkillMapper;
import api.tchiiwa.microservice.features.skill.domain.models.SkillModel;
import api.tchiiwa.microservice.features.skill.infrastructure.entity.SkillEntity;
import api.tchiiwa.microservice.features.skill.infrastructure.repository.SkillRepository;
import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SkillServices implements SkillServiceInPort {
    private final SkillRepository skillRepository;
    private final PersonRepository personRepository;
    private final SkillMapper skillMapper;

    @Inject
    public SkillServices(SkillRepository skillRepository, PersonRepository personRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.personRepository = personRepository;
        this.skillMapper = skillMapper;
    }

    @Transactional
    @Override
    public PaginatedSkillsResponseDTO getAllSkills(PaginationSkillRequestDTO dto) {
        PaginatedSkillsResponseDTO response = new PaginatedSkillsResponseDTO();

        long allSkills = this.skillRepository.findAll().size();

        // Fetch filtered list for total count (with personId filter, no pagination)
        List<SkillModel> filteredList = this.skillRepository.findAll(
                0,
                Integer.MAX_VALUE,
                dto.getPersonId()
        );

        // Fetch paginated and filtered skills
        List<SkillResponseDTO> skills = this.skillRepository
                .findAll(dto.getPage(), dto.getSize(), dto.getPersonId())
                .stream()
                .map(skillMapper::toResponseDTO)
                .toList();

        // Calculate pagination details
        int totalItems = filteredList.size();
        int totalPages = (int) Math.ceil((double) totalItems / dto.getSize());
        Integer nextPage = (dto.getPage() + 1 >= totalPages) ? null : dto.getPage() + 1;

        // Build pagination response
        PaginationResponseDTO pagination = new PaginationResponseDTO();
        pagination.setCurrentPage(dto.getPage());
        pagination.setTotalItems(totalItems);
        pagination.setTotalCurrentItems(skills.size());
        pagination.setTotalPages(totalPages);
        pagination.setNextPage(nextPage);
        pagination.setAllItems(allSkills);

        // Set response data
        response.setSkills(skills);
        response.setPaginationResponseDTO(pagination);

        return response;
    }

    @Override
    public SkillResponseDTO getSkillById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return this.skillRepository.findByUuid(uuid)
                    .map(skillMapper::toResponseDTO)
                    .orElseThrow(() -> new SkillNotFoundException("Skill not found with uuid " + uuid));
        } catch (IllegalArgumentException e) {
            try {
                Long longId = Long.parseLong(id);
                return this.skillRepository.findById(longId)
                        .map(skillMapper::toResponseDTO)
                        .orElseThrow(() -> new SkillNotFoundException("Skill not found with id " + longId));
            } catch (NumberFormatException ex) {
                throw new SkillIdNotValidException("Skill id is not valid");
            }
        }
    }

    @Transactional
    @Override
    public SkillResponseDTO createSkill(SkillCreateRequestDTO skillCreateRequestDTO) {
        PersonModel person = this.personRepository.findById(skillCreateRequestDTO.getPersonId())
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id " + skillCreateRequestDTO.getPersonId()));

        Optional<SkillModel> skillCheck = this.skillRepository.findByPersonIdAndName(skillCreateRequestDTO.getPersonId(), skillCreateRequestDTO.getName());

        if (skillCheck.isPresent()) {
            throw new SkillConflictException("Skill already exists for person id " + skillCreateRequestDTO.getPersonId());
        }

        SkillModel skillModel = new SkillModel();
        skillModel.setName(skillCreateRequestDTO.getName());
        skillModel.setLevel(skillCreateRequestDTO.getLevel());
        skillModel.setPerson(person);

        return this.skillMapper.toResponseDTO(this.skillRepository.create(skillModel));
    }

    @Transactional
    @Override
    public SkillResponseDTO updateSkill(Long id, SkillUpdateRequestDTO dto) {
        SkillEntity entity = skillRepository.getEntityManager()
                .find(SkillEntity.class, id);

        if (entity == null) {
            throw new SkillNotFoundException("Skill not found with id " + id);
        }

        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getLevel() != null) entity.setLevel(dto.getLevel());

        return skillMapper.toResponseDTO(skillMapper.toModel(entity));
    }

    @Transactional
    @Override
    public void deleteSkill(Long id) {
        this.skillRepository.findById(id)
                .orElseThrow(() -> new SkillNotFoundException("Skill not found with id " + id));

        this.skillRepository.deleteById(id);
    }
}