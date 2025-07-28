package api.tchiiwa.microservice.imports.user.infrastructure.repository;

import api.tchiiwa.microservice.imports.user.infrastructure.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PnUserRepository implements PanacheRepository<UserEntity> {}