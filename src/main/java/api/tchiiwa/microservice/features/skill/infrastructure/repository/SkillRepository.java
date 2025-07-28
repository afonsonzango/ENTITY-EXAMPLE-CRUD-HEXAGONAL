package api.tchiiwa.microservice.features.skill.infrastructure.repository;

import api.tchiiwa.microservice.features.skill.application.ports.out.SkillRepositoryOutPort;
import api.tchiiwa.microservice.features.skill.domain.mappers.SkillMapper;
import api.tchiiwa.microservice.features.skill.domain.models.SkillModel;
import api.tchiiwa.microservice.features.skill.infrastructure.entity.SkillEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SkillRepository implements SkillRepositoryOutPort {
    private final PnSkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Inject
    public SkillRepository(PnSkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    public EntityManager getEntityManager() {
        return skillRepository.getEntityManager();
    }

    @Override
    public List<SkillModel> findAll() {
        return skillRepository
                .findAll()
                .stream()
                .map(skillMapper::toModel)
                .toList();
    }

    @Override
    public List<SkillModel> findAll(int page, int size, Long personId) {
        return (personId != null
                ? skillRepository.find("person.id", personId)
                : skillRepository.findAll()
        )
        .page(page, size)
        .list()
        .stream()
        .map(skillMapper::toModel)
        .toList();
    }

    @Override
    public Optional<SkillModel> findById(Long id) {
        return skillRepository.findByIdOptional(id)
                .map(skillMapper::toModel);
    }

    @Override
    public Optional<SkillModel> findByUuid(UUID uuid) {
        return skillRepository.find("uuid", uuid).firstResultOptional()
                .map(skillMapper::toModel);
    }

    @Override
    public Optional<SkillModel> findByPersonIdAndName(Long personId, String name) {
        return skillRepository.find("person.id = ?1 and name = ?2", personId, name)
                .firstResultOptional()
                .map(skillMapper::toModel);
    }

    @Override
    public SkillModel create(SkillModel skillModel) {
        SkillEntity skillEntity = skillMapper.toEntity(skillModel);
        skillRepository.persist(skillEntity);
        return skillMapper.toModel(skillEntity);
    }

    @Override
    public SkillModel update(SkillModel skillModel) {
        SkillEntity skillEntity = skillMapper.toEntity(skillModel);
        skillRepository.getEntityManager().merge(skillEntity);
        return skillMapper.toModel(skillEntity);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}