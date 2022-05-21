package com.avdemchenko.rest.person

import io.agroal.api.AgroalDataSource
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PersonRepository @Inject constructor(val dataSource: AgroalDataSource) {

    fun findById(id: Int): Person? {
        var person: Person? = null
        dataSource.connection.use { connection ->
            connection.prepareStatement("SELECT * FROM company.public.persons WHERE id = ?").use { statement ->
                statement.setObject(1, id)

                val resultSet = statement.executeQuery()

                while (resultSet.next()) {
                    val id = resultSet.getInt(1)
                    val name = resultSet.getString(2)
                    val age = resultSet.getInt(3)

                    person = Person(id, name, age)
                }
            }
        }
        return person
    }
}
