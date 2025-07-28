package api.tchiiwa.microservice.imports.user.application.ports.out;

import api.tchiiwa.microservice.imports.user.domain.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryOutPort {
    List<UserModel> findAll();

    List<UserModel> findAll(int page, int size);

    Optional<UserModel> findById(Long id);

    Optional<UserModel> findByUuid(UUID uuid);

    UserModel create(UserModel userModel);

    Optional<UserModel> findByAuthContactId(Long authContactId);

    void deleteById(Long id);
}