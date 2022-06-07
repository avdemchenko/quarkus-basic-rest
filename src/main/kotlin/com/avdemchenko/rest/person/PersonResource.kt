package com.avdemchenko.rest.person

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/person")
class PersonResource @Inject constructor(val personService: PersonService) {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPerson(@PathParam("id") id: Int) =
            Response.ok(personService.getPerson(id)).build()
}
