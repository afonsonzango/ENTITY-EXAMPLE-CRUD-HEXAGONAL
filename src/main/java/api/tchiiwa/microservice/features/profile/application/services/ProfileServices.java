package api.tchiiwa.microservice.features.profile.application.services;

import api.tchiiwa.microservice.features.profile.application.dtos.*;
import api.tchiiwa.microservice.features.profile.application.ports.in.ProfileServiceInPort;
import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileConflictException;
import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileIdNotValidException;
import api.tchiiwa.microservice.features.profile.domain.exceptions.ProfileNotFoundException;
import api.tchiiwa.microservice.features.profile.domain.mappers.ProfileMapper;
import api.tchiiwa.microservice.features.profile.domain.models.ProfileModel;
import api.tchiiwa.microservice.features.profile.infrastructure.entity.ProfileEntity;
import api.tchiiwa.microservice.features.profile.infrastructure.repository.ProfileRepository;
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
public class ProfileServices implements ProfileServiceInPort {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    @Inject
    public ProfileServices(ProfileRepository profileRepository, UserRepository userRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.profileMapper = profileMapper;
    }

    @Transactional
    @Override
    public PaginatedProfilesResponseDTO getAllProfiles(PaginationProfileRequestDTO paginationProfileRequestDTO) {
        PaginatedProfilesResponseDTO response = new PaginatedProfilesResponseDTO();

        // Total de todos os perfis (sem filtro)
        long allProfiles = this.profileRepository.findAll().size();

        // Lista completa filtrada para calcular total de itens filtrados
        List<ProfileModel> filteredList = this.profileRepository.findAll(0, Integer.MAX_VALUE, paginationProfileRequestDTO.getUserId());

        // Página atual paginada e convertida para DTO
        List<ProfileResponseDTO> profiles = this.profileRepository
                .findAll(paginationProfileRequestDTO.getPage(), paginationProfileRequestDTO.getSize(), paginationProfileRequestDTO.getUserId())
                .stream()
                .map(profileMapper::toResponseDTO)
                .toList();

        // Cálculo de paginação
        int totalItems = filteredList.size();
        int totalPages = (int) Math.ceil((double) totalItems / paginationProfileRequestDTO.getSize());
        Integer nextPage = (paginationProfileRequestDTO.getPage() + 1 >= totalPages) ? null : paginationProfileRequestDTO.getPage() + 1;

        // Preenchendo objeto de paginação
        PaginationResponseDTO pagination = new PaginationResponseDTO();
        pagination.setCurrentPage(paginationProfileRequestDTO.getPage());
        pagination.setTotalItems(totalItems);
        pagination.setTotalCurrentItems(profiles.size());
        pagination.setTotalPages(totalPages);
        pagination.setNextPage(nextPage);
        pagination.setAllItems(allProfiles);

        // Setando dados na resposta final
        response.setProfiles(profiles);
        response.setPaginationResponseDTO(pagination);

        return response;
    }

    @Override
    public ProfileResponseDTO getProfileById(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return this.profileRepository.findByUuid(uuid)
                    .map(profileMapper::toResponseDTO)
                    .orElseThrow(() -> new ProfileNotFoundException("Profile not found with uuid " + uuid));
        } catch (IllegalArgumentException e) {
            try {
                Long longId = Long.parseLong(id);
                return this.profileRepository.findById(longId)
                        .map(profileMapper::toResponseDTO)
                        .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id " + longId));
            } catch (NumberFormatException ex) {
                throw new ProfileIdNotValidException("Profile id is not valid");
            }
        }
    }

    @Transactional
    @Override
    public ProfileResponseDTO createProfile(ProfileCreateRequestDTO profileCreateRequestDTO) {
        UserModel user = this.userRepository.findById(profileCreateRequestDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + profileCreateRequestDTO.getUserId()));

        // Check for existing profile for the user
        if (user.getProfile() != null) {
            throw new ProfileConflictException("Profile already exists for user id " + profileCreateRequestDTO.getUserId());
        }

        ProfileModel profileModel = new ProfileModel();
        profileModel.setDisplayName(profileCreateRequestDTO.getDisplayName());
        profileModel.setBio(profileCreateRequestDTO.getBio());
        profileModel.setIsPublic(profileCreateRequestDTO.getIsPublic());
        profileModel.setUser(user);

        return this.profileMapper.toResponseDTO(this.profileRepository.create(profileModel));
    }

    @Transactional
    @Override
    public ProfileResponseDTO updateProfile(Long id, ProfileUpdateRequestDTO dto) {
        ProfileEntity entity = profileRepository
                .getEntityManager()
                .find(ProfileEntity.class, id);

        if (entity == null) {
            throw new ProfileNotFoundException("Profile not found with id " + id);
        }

        if (dto.getDisplayName() != null) entity.setDisplayName(dto.getDisplayName());
        if (dto.getBio() != null) entity.setBio(dto.getBio());
        if (dto.getIsPublic() != null) entity.setIsPublic(dto.getIsPublic());

        return this.profileMapper.toResponseDTO(this.profileMapper.toModel(entity));
    }

    @Transactional
    @Override
    public void deleteProfile(Long id) {
        ProfileEntity entity = this.profileRepository
                .getEntityManager()
                .find(ProfileEntity.class, id);

        if (entity == null) {
            throw new ProfileNotFoundException("No profile found by the provided id");
        }

        entity.setUser(null);

        this.profileRepository.deleteById(id);
    }
}