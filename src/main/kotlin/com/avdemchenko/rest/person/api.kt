package com.avdemchenko.rest.person

data class PersonNotFoundException(val id: Int) : RuntimeException("Person with id = $id not found!")
