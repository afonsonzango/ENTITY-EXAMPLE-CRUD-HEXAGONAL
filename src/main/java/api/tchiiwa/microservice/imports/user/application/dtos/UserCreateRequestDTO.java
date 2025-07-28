package api.tchiiwa.microservice.imports.user.application.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreateRequestDTO {
    @NotNull(message = "user id cannot be null")
    private Long id;

    @NotNull(message = "uuid cannot be null")
    private UUID uuid;

    @NotNull(message = "createdAt cannot be null")
    private LocalDateTime createdAt;

    @NotNull(message = "updatedAt cannot be null")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}