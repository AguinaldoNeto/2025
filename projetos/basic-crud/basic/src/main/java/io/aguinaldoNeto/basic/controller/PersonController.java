package io.aguinaldoNeto.basic.controller;

import io.aguinaldoNeto.basic.controller.dto.PersonDTO;
import io.aguinaldoNeto.basic.model.Person;
import io.aguinaldoNeto.basic.service.impl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personDTO) {
        Person createdPerson  = personService.create(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAllPersons() {
        List<Person> personsList = personService.getAll();
        return ResponseEntity.ok().body(personsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id) {
        Person personFounded = personService.findById(id);
        return ResponseEntity.ok().body(personFounded);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody PersonDTO personDTO) {
        Person person = personService.update(id, personDTO);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }


}