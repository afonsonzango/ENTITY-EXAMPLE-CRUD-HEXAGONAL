package api.tchiiwa.microservice.features.profile.application.ports.in;


import api.tchiiwa.microservice.features.profile.application.dtos.*;

public interface ProfileServiceInPort {
    PaginatedProfilesResponseDTO getAllProfiles(PaginationProfileRequestDTO paginationProfileRequestDTO);

    ProfileResponseDTO getProfileById(String id);

    ProfileResponseDTO createProfile(ProfileCreateRequestDTO profileCreateRequestDTO);

    ProfileResponseDTO updateProfile(Long id, ProfileUpdateRequestDTO profileUpdateRequestDTO);

    void deleteProfile(Long id);
}