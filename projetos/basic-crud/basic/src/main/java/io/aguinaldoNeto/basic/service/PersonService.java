package io.aguinaldoNeto.basic.service;

import io.aguinaldoNeto.basic.controller.dto.PersonDTO;
import io.aguinaldoNeto.basic.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person createPerson(PersonDTO personDTO);

}