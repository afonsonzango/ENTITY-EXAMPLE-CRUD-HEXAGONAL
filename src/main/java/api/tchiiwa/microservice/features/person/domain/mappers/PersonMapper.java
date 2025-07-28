package api.tchiiwa.microservice.features.person.domain.mappers;

import api.tchiiwa.microservice.features.person.application.dtos.PersonResponseDTO;
import api.tchiiwa.microservice.features.person.domain.models.PersonModel;
import api.tchiiwa.microservice.features.person.infrastructure.entity.PersonEntity;
import api.tchiiwa.microservice.features.skill.domain.mappers.SkillMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", uses = { SkillMapper.class })
public interface PersonMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "skills", ignore = true)
    PersonModel toModel(PersonEntity entity);

    PersonEntity toEntity(PersonModel model);

    PersonResponseDTO toResponseDTO(PersonModel model);
}
