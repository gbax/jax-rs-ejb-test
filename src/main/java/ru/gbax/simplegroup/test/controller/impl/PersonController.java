package ru.gbax.simplegroup.test.controller.impl;

import ru.gbax.simplegroup.test.model.Person;
import ru.gbax.simplegroup.test.service.PersonService;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Контроллер для работы с данными человека
 * Created by GBAX on 04.07.2015.
 */

@Stateful
@Path("/")
public class PersonController {

    @EJB
    private PersonService personService;

    /**
     * Главная страница
     * @param response
     * @param request
     */
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public void index(@Context HttpServletResponse response,
                      @Context HttpServletRequest request) {
        try {
            request.getRequestDispatcher("../WEB-INF/templates/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает данные по человеку
     * @return
     */
    @GET
    @Path("/getPerson")
    public Response getPerson() {
        String entity = personService.getPersonAsJSON();
        return Response.ok(entity, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }

    /**
     * Сохраняет данные по человеку
     * @return
     */
    @POST
    @Path("/savePerson")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson(Person updatedPerson) {
        personService.setPerson(updatedPerson);
        String entity = personService.getPersonAsJSON();
        return Response.ok(entity, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }

}
