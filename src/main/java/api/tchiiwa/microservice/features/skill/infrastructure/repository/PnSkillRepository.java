package api.tchiiwa.microservice.features.skill.infrastructure.repository;

import api.tchiiwa.microservice.features.skill.infrastructure.entity.SkillEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PnSkillRepository implements PanacheRepository<SkillEntity> {}