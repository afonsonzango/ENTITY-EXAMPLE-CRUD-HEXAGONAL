package api.tchiiwa.microservice.features.profile.infrastructure.repository;

import api.tchiiwa.microservice.features.profile.application.ports.out.ProfileRepositoryOutPort;
import api.tchiiwa.microservice.features.profile.domain.mappers.ProfileMapper;
import api.tchiiwa.microservice.features.profile.domain.models.ProfileModel;
import api.tchiiwa.microservice.features.profile.infrastructure.entity.ProfileEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ProfileRepository implements ProfileRepositoryOutPort {
    private final PnProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Inject
    public ProfileRepository(PnProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    public EntityManager getEntityManager() {
        return profileRepository.getEntityManager();
    }

    @Override
    public List<ProfileModel> findAll() {
        return profileRepository
                .findAll()
                .stream()
                .map(profileMapper::toModel)
                .toList();
    }

    @Override
    public List<ProfileModel> findAll(int page, int size, Long userId) {
        return (userId != null
                ? profileRepository.find("user.id", userId)
                : profileRepository.findAll()
        )
                .page(page, size)
                .list()
                .stream()
                .map(profileMapper::toModel)
                .toList();
    }

    @Override
    public Optional<ProfileModel> findById(Long id) {
        return profileRepository.findByIdOptional(id)
                .map(profileMapper::toModel);
    }

    @Override
    public Optional<ProfileModel> findByUuid(UUID uuid) {
        return profileRepository.find("uuid", uuid).firstResultOptional()
                .map(profileMapper::toModel);
    }

    @Override
    public ProfileModel create(ProfileModel profileModel) {
        ProfileEntity profileEntity = profileMapper.toEntity(profileModel);
        profileRepository.persist(profileEntity);
        return profileMapper.toModel(profileEntity);
    }

    @Override
    public ProfileModel update(ProfileModel profileModel) {
        ProfileEntity profileEntity = profileMapper.toEntity(profileModel);
        profileRepository.getEntityManager().merge(profileEntity);
        return profileMapper.toModel(profileEntity);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}