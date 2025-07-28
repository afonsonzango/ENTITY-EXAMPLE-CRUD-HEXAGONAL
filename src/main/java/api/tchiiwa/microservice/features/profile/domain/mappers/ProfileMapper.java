package api.tchiiwa.microservice.features.profile.domain.mappers;

import api.tchiiwa.microservice.features.profile.application.dtos.ProfileResponseDTO;
import api.tchiiwa.microservice.features.profile.domain.models.ProfileModel;
import api.tchiiwa.microservice.features.profile.infrastructure.entity.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi", uses = {})
public interface ProfileMapper {
    @Mapping(target = "user", ignore = true)
    ProfileModel toModel(ProfileEntity entity);

    ProfileEntity toEntity(ProfileModel model);

    ProfileResponseDTO toResponseDTO(ProfileModel model);
}
