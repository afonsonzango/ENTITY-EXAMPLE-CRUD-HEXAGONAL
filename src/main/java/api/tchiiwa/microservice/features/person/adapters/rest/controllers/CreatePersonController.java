package api.tchiiwa.microservice.features.person.adapters.rest.controllers;

import api.tchiiwa.microservice.features.person.application.dtos.PersonCreateRequestDTO;
import api.tchiiwa.microservice.features.person.application.dtos.PersonResponseDTO;
import api.tchiiwa.microservice.features.person.application.services.PersonServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.apache.camel.Body;

@Path("person")
public class CreatePersonController {
    private final PersonServices personServices;

    @Inject
    public CreatePersonController (PersonServices personServices) {
        this.personServices = personServices;
    }

    @POST
    @Path("create")
    public PersonResponseDTO createPerson(
        @Valid @Body() PersonCreateRequestDTO personCreateRequestDTO
    ) {
        return this.personServices.createPerson(personCreateRequestDTO);
    }
}