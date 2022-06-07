package com.avdemchenko.rest.person

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider


@Provider
class ExceptionHandler : ExceptionMapper<PersonNotFoundException> {
    override fun toResponse(exception: PersonNotFoundException) =
        Response.status(Response.Status.BAD_REQUEST).entity(exception.message).build()
}
