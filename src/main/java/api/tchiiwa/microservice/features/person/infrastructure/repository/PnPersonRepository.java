package api.tchiiwa.microservice.features.person.infrastructure.repository;

import api.tchiiwa.microservice.features.person.infrastructure.entity.PersonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PnPersonRepository implements PanacheRepository<PersonEntity> {}
