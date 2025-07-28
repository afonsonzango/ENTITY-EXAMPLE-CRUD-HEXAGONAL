package api.tchiiwa.microservice.imports.user.domain.mappers;

import api.tchiiwa.microservice.features.person.domain.mappers.PersonMapper;
import api.tchiiwa.microservice.features.profile.domain.mappers.ProfileMapper;
import api.tchiiwa.microservice.imports.user.application.dtos.UserResponseDTO;
import api.tchiiwa.microservice.imports.user.domain.models.UserModel;
import api.tchiiwa.microservice.imports.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = { PersonMapper.class, ProfileMapper.class })
public interface UserMapper {
    UserModel toModel(UserEntity entity);

    UserEntity toEntity(UserModel model);

    UserResponseDTO toResponseDTO(UserModel model);
}