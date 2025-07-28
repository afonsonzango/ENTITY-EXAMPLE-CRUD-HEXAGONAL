package api.tchiiwa.microservice.root.core.exeptions.exeptions_dtos;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
public class ErrorResponse {
    public String code;
    public List<String> messages;

    public ErrorResponse() {}

    public ErrorResponse(String code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }
}