package api.tchiiwa.microservice.imports.user.application.services;

import api.tchiiwa.microservice.imports.user.application.dtos.PaginatedUsersResponseDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.PaginationUserRequestDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.UserCreateRequestDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.UserResponseDTO;
import api.tchiiwa.microservice.imports.user.application.ports.in.UserServiceInPort;
import api.tchiiwa.microservice.imports.user.domain.exeptions.UserIdNotValidException;
import api.tchiiwa.microservice.imports.user.domain.exeptions.UserNotFoundException;
import api.tchiiwa.microservice.imports.user.domain.mappers.UserMapper;
import api.tchiiwa.microservice.imports.user.domain.models.UserModel;
import api.tchiiwa.microservice.imports.user.infrastructure.repository.UserRepository;
import api.tchiiwa.microservice.root.shared.dtos.PaginationResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserServices implements UserServiceInPort {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Inject
    public UserServices(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public PaginatedUsersResponseDTO getAllUsers(PaginationUserRequestDTO dto) {
        PaginatedUsersResponseDTO response = new PaginatedUsersResponseDTO();

        long allUsers = this.userRepository.findAll().size();

        // Fetch all users for total count (no pagination)
        List<UserModel> filteredList = this.userRepository.findAll(
                0,
                Integer.MAX_VALUE
        );

        // Fetch paginated users
        List<UserResponseDTO> users = this.userRepository
                .findAll(dto.getPage(), dto.getSize())
                .stream()
                .map(userMapper::toResponseDTO)
                .toList();

        // Calculate pagination details
        int totalItems = filteredList.size();
        int totalPages = (int) Math.ceil((double) totalItems / dto.getSize());
        Integer nextPage = (dto.getPage() + 1 >= totalPages) ? null : dto.getPage() + 1;

        // Build pagination response
        PaginationResponseDTO pagination = new PaginationResponseDTO();
        pagination.setCurrentPage(dto.getPage());
        pagination.setTotalItems(totalItems);
        pagination.setTotalCurrentItems(users.size());
        pagination.setTotalPages(totalPages);
        pagination.setNextPage(nextPage);
        pagination.setAllItems(allUsers);

        // Set response data
        response.setUsers(users);
        response.setPaginationResponseDTO(pagination);

        return response;
    }

    @Override
    public UserResponseDTO getUserById(String id) {
        try {
            UUID uuid = UUID.fromString(id);

            return this.userRepository.findByUuid(uuid)
                    .map(userMapper::toResponseDTO)
                    .orElseThrow(() -> new UserNotFoundException("User not found with uuid " + uuid));
        } catch (IllegalArgumentException e) {
            try {
                Long longId = Long.parseLong(id);
                return this.userRepository.findById(longId)
                        .map(userMapper::toResponseDTO)
                        .orElseThrow(() -> new UserNotFoundException("User not found with id " + longId));
            } catch (NumberFormatException ex) {
                throw new UserIdNotValidException("User id is not valid");
            }
        }
    }

    @Transactional
    @Override
    public UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {
        UserModel user = new UserModel();

        user.setId(userCreateRequestDTO.getId());
        user.setUuid(userCreateRequestDTO.getUuid());
        user.setCreatedAt(userCreateRequestDTO.getCreatedAt());
        user.setUpdatedAt(userCreateRequestDTO.getUpdatedAt());

        return this.userMapper.toResponseDTO(userRepository.create(user));
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        this.userRepository.deleteById(id);
    }
}
