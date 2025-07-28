package api.tchiiwa.microservice.features.profile.infrastructure.repository;

import api.tchiiwa.microservice.features.profile.infrastructure.entity.ProfileEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PnProfileRepository implements PanacheRepository<ProfileEntity> {}