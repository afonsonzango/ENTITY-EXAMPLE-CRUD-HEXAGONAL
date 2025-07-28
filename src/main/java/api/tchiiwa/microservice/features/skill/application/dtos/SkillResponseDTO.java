package api.tchiiwa.microservice.features.skill.application.dtos;

import api.tchiiwa.microservice.features.person.domain.models.PersonModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class SkillResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private Integer level;
    private PersonModel person;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SkillResponseDTO() {
    }

    public SkillResponseDTO(Long id, UUID uuid, String name, Integer level, PersonModel person, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.level = level;
        this.person = person;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
