package api.tchiiwa.microservice.features.person.adapters.rest.controllers;

import api.tchiiwa.microservice.features.person.application.dtos.PaginatedPersonsResponseDTO;
import api.tchiiwa.microservice.features.person.application.dtos.PaginationPersonRequestDTO;
import api.tchiiwa.microservice.features.person.application.services.PersonServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("person")
public class GetPersonsController {
    private final PersonServices personServices;

    @Inject
    public GetPersonsController (PersonServices personServices) {
        this.personServices = personServices;
    }

    @GET
    @Path("all")
    public PaginatedPersonsResponseDTO getPersons(
            @Valid @BeanParam PaginationPersonRequestDTO paginationPersonRequestDTO
    ) {
        return this.personServices.getAllPersons(paginationPersonRequestDTO);
    }
}