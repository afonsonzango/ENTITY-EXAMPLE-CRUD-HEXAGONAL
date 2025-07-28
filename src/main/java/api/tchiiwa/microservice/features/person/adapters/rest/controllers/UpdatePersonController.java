package api.tchiiwa.microservice.features.person.adapters.rest.controllers;

import api.tchiiwa.microservice.features.person.application.dtos.PersonResponseDTO;
import api.tchiiwa.microservice.features.person.application.dtos.PersonUpdateRequestDTO;
import api.tchiiwa.microservice.features.person.application.services.PersonServices;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.apache.camel.Body;

@Path("person")
public class UpdatePersonController {
    private final PersonServices personServices;

    @Inject
    public UpdatePersonController (PersonServices personServices) {
        this.personServices = personServices;
    }

    @PUT
    @Path("update/{id}")
    public PersonResponseDTO updatePerson(
            @PathParam("id") Long id,
            @Valid @Body() PersonUpdateRequestDTO personUpdateRequestDTO
    ) {
        return this.personServices.updatePerson(id, personUpdateRequestDTO);
    }
}