package com.senai.sc.ProjetoAplicado3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.sc.ProjetoAplicado3.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findCandidateByName(String name);
	List<Person> findCandidateBySex(String sex);
	List<Person> findCandidateByDisability(String disability);
	List<Person> findCandidateByTelNumber(String telNumber);
	List<Person> findCandidateByEmail(String email);
	List<Person> findCandidateByPostalCode(String postalCode);
}
