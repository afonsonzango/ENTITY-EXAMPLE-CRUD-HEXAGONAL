package api.tchiiwa.microservice.features.skill.application.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.QueryParam;

public class PaginationSkillRequestDTO {
    @QueryParam("page")
    @Min(value = 0, message = "A página deve ser maior ou igual a 0")
    private int page;

    @QueryParam("size")
    @Min(value = 1, message = "O tamanho deve ser no mínimo 1")
    @Max(value = 100, message = "O tamanho máximo permitido é 100")
    private int size;

    @QueryParam("personId")
    private Long personId;

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public Long getPersonId() {
        return personId;
    }
}
