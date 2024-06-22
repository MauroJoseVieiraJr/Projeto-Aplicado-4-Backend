package com.senai.sc.ProjetoAplicado4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.sc.ProjetoAplicado4.entity.Necessity;

public interface NecessityRepository extends JpaRepository<Necessity, Long> {
	List<Necessity> findNecessityByDisability(String disability);
	List<Necessity> findNecessityByDescription(String description);
	List<Necessity> findNecessityByPostalCode(String postalCode);
}
