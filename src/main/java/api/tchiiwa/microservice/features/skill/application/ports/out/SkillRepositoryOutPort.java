package api.tchiiwa.microservice.features.skill.application.ports.out;

import api.tchiiwa.microservice.features.skill.domain.models.SkillModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillRepositoryOutPort {
    List<SkillModel> findAll();

    List<SkillModel> findAll(int page, int size, Long personId);

    Optional<SkillModel> findById(Long id);

    Optional<SkillModel> findByUuid(UUID uuid);

    Optional<SkillModel> findByPersonIdAndName(Long personId, String name);

    SkillModel create(SkillModel skillModel);

    SkillModel update(SkillModel skillModel);

    void deleteById(Long id);
}
