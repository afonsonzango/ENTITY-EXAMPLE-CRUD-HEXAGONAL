package api.tchiiwa.microservice.features.person.application.dtos;

import api.tchiiwa.microservice.features.person.domain.enums.GenderEnum;
import api.tchiiwa.microservice.features.skill.domain.models.SkillModel;
import api.tchiiwa.microservice.imports.user.domain.models.UserModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PersonResponseDTO {
    private Long id;
    private UUID uuid;
    private GenderEnum gender;
    private String firstName;
    private String lastName;
    private String birthDate;
    private UserModel user;
    private List<SkillModel> skills;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PersonResponseDTO() {
    }

    public PersonResponseDTO(Long id, UUID uuid, GenderEnum gender, String firstName, String lastName, String birthDate, UserModel user, List<SkillModel> skills, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.user = user;
        this.skills = skills;
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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<SkillModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillModel> skills) {
        this.skills = skills;
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