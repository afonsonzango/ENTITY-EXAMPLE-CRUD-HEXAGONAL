package api.tchiiwa.microservice.features.person.adapters.rest.controllers;

import api.tchiiwa.microservice.features.person.application.dtos.PersonResponseDTO;
import api.tchiiwa.microservice.features.person.application.services.PersonServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("person")
public class GetPersonByIdController {
    private final PersonServices personServices;

    @Inject
    public GetPersonByIdController (PersonServices personServices) {
        this.personServices = personServices;
    }

    @GET
    @Path("get/{id}")
    public PersonResponseDTO getPersonById(
            @PathParam("id") String id
    ) {
        return this.personServices.getPersonById(id);
    }
}