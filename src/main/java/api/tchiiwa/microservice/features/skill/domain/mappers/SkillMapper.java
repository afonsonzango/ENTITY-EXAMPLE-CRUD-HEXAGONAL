package api.tchiiwa.microservice.features.skill.domain.mappers;

import api.tchiiwa.microservice.features.skill.application.dtos.SkillResponseDTO;
import api.tchiiwa.microservice.features.skill.domain.models.SkillModel;
import api.tchiiwa.microservice.features.skill.infrastructure.entity.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", uses = {})
public interface SkillMapper {
    @Mapping(target = "person", ignore = true)
    SkillModel toModel(SkillEntity entity);

    SkillEntity toEntity(SkillModel model);

    SkillResponseDTO toResponseDTO(SkillModel model);
}