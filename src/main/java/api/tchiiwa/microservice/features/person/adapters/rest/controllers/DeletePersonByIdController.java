package api.tchiiwa.microservice.features.person.adapters.rest.controllers;

import api.tchiiwa.microservice.features.person.application.services.PersonServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("person")
public class DeletePersonByIdController {
    private final PersonServices personServices;

    @Inject
    public DeletePersonByIdController (PersonServices personServices) {
        this.personServices = personServices;
    }

    @DELETE
    @Path("delete/{id}")
    public void deletePersonById(
            @PathParam("id") Long id
    ) {
        this.personServices.deletePerson(id);
    }
}