package io.aguinaldoNeto.basic.controller;

import io.aguinaldoNeto.basic.controller.dto.PersonDTO;
import io.aguinaldoNeto.basic.model.Person;
import io.aguinaldoNeto.basic.service.impl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        Person createdPerson  = personService.createPerson(personDTO);
        if (isNull(createdPerson))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }


    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> personsList = personService.getAllPersons();

        return ResponseEntity.ok(personsList);
    }

}