package com.senai.sc.ProjetoAplicado4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.ProjetoAplicado4.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findPersonByName(String name);
	List<Person> findPersonBySex(String sex);
	List<Person> findPersonByDisability(String disability);
	List<Person> findPersonByTelNumber(String telNumber);
	List<Person> findPersonByEmail(String email);
	List<Person> findPersonByPostalCode(String postalCode);
}
