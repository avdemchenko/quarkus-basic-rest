package com.avdemchenko.rest.person

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PersonService @Inject constructor(val personRepository: PersonRepository) {

    fun getPerson(id: Int) = personRepository.findById(id) ?: throw PersonNotFoundException(id)
}
