package api.tchiiwa.microservice.imports.user.infrastructure.repository;

import api.tchiiwa.microservice.imports.user.application.ports.out.UserRepositoryOutPort;
import api.tchiiwa.microservice.imports.user.domain.mappers.UserMapper;
import api.tchiiwa.microservice.imports.user.domain.models.UserModel;
import api.tchiiwa.microservice.imports.user.infrastructure.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements UserRepositoryOutPort {
    private final PnUserRepository userRepository;
    private final UserMapper userMapper;

    @Inject
    public UserRepository(PnUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toModel)
                .toList();
    }

    @Override
    public List<UserModel> findAll(int page, int size) {
        return userRepository
                .findAll()
                .page(page, size)
                .stream()
                .map(userMapper::toModel)
                .toList();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return userRepository.findByIdOptional(id)
                .map(userMapper::toModel);
    }

    @Override
    public Optional<UserModel> findByUuid(UUID uuid) {
        return userRepository.find("uuid", uuid).firstResultOptional()
                .map(userMapper::toModel);
    }

    @Override
    public Optional<UserModel> findByAuthContactId(Long authContactId) {
        return userRepository
                .find("JOIN authContacts a WHERE a.id = ?1", authContactId)
                .firstResultOptional()
                .map(userMapper::toModel);
    }

    @Override
    public UserModel create(UserModel userModel) {
        UserEntity userEntity = userMapper.toEntity(userModel);
        userRepository.persist(userEntity);
        return userMapper.toModel(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}