package api.tchiiwa.microservice.root.shared.dtos;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ErrorResponseDTO {
    public String code;
    public String message;

    public ErrorResponseDTO() {}

    public ErrorResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
}