package io.aguinaldoNeto.basic.service.impl;

import io.aguinaldoNeto.basic.controller.dto.PersonDTO;
import io.aguinaldoNeto.basic.model.Person;
import io.aguinaldoNeto.basic.repository.PersonRepository;
import io.aguinaldoNeto.basic.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(PersonDTO personDTO) {
        Person person = new Person();
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setEmail(personDTO.getEmail());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        person.setDateOfBirth(personDTO.getDateOfBirth());

        return personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O ID não foi encontrado. Insira um ID válido."));
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person update(Long id, PersonDTO personDTO) {
        Person foundedPerson  = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O ID não foi encontrado. Insira um ID válido."));;

        foundedPerson.setFirstName(personDTO.getFirstName());
        foundedPerson.setLastName(personDTO.getLastName());
        foundedPerson.setEmail(personDTO.getEmail());
        foundedPerson.setPhoneNumber(personDTO.getPhoneNumber());
        foundedPerson.setDateOfBirth(personDTO.getDateOfBirth());

        return personRepository.save(foundedPerson);
    }

    @Override
    public void delete(Long id) {
        Person foundedPersonId = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("O ID não foi encontrado. Insira um ID válido."));

        personRepository.delete(foundedPersonId);
    }


}