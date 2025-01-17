package io.aguinaldoNeto.basic.service;

import io.aguinaldoNeto.basic.controller.dto.PersonDTO;
import io.aguinaldoNeto.basic.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    Person create(PersonDTO personDTO);

    Person findById(Long id);

    Person update(Long id, PersonDTO personDTO);

    void delete(Long id);
}