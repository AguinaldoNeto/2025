package io.aguinaldoNeto.basic.repository;

import io.aguinaldoNeto.basic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}