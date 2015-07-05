package ru.gbax.simplegroup.test.controller.impl;

import ru.gbax.simplegroup.test.freemarker.FreemarkerProvider;
import ru.gbax.simplegroup.test.model.Person;
import ru.gbax.simplegroup.test.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by GBAX on 04.07.2015.
 */

@Stateless
@Path("/")
public class PersonController {

    @EJB
    private PersonService personService;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public Response printMessage() {
        Response rsp = null;
        try {
            final String o = new String(FreemarkerProvider.templateProcess(null, "index").toByteArray(), "UTF-8");
            rsp = Response.status(200).entity(o).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsp;

    }

    @GET
    @Path("/getPerson")
    public Response getPerson() {
        String entity = personService.getPersonAsJSON();
        return Response.ok(entity, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }

    @POST
    @Path("/savePerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson(Person updatedPerson) {
        personService.setPerson(updatedPerson);
        String entity = personService.getPersonAsJSON();
        return Response.ok(entity, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }

}
