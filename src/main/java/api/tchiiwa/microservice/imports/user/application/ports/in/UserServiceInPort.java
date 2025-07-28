package api.tchiiwa.microservice.imports.user.application.ports.in;

import api.tchiiwa.microservice.imports.user.application.dtos.PaginatedUsersResponseDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.PaginationUserRequestDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.UserCreateRequestDTO;
import api.tchiiwa.microservice.imports.user.application.dtos.UserResponseDTO;

public interface UserServiceInPort {
    PaginatedUsersResponseDTO getAllUsers(PaginationUserRequestDTO dto);

    UserResponseDTO getUserById(String id);

    UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);

    void deleteUser(Long id);
}
