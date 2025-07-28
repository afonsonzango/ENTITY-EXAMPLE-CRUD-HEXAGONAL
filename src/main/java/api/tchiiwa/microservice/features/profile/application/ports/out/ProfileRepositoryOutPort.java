package api.tchiiwa.microservice.features.profile.application.ports.out;

import api.tchiiwa.microservice.features.profile.domain.models.ProfileModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfileRepositoryOutPort {
    List<ProfileModel> findAll();

    List<ProfileModel> findAll(int page, int size, Long userId);

    Optional<ProfileModel> findById(Long id);

    Optional<ProfileModel> findByUuid(UUID uuid);

    ProfileModel create(ProfileModel profileModel);

    ProfileModel update(ProfileModel profileModel);

    void deleteById(Long id);
}