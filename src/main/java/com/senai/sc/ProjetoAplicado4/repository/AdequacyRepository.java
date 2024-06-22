package com.senai.sc.ProjetoAplicado4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.sc.ProjetoAplicado4.entity.Adequacy;

public interface AdequacyRepository extends JpaRepository<Adequacy, Long> {
	List<Adequacy> findAdequacyByDisability(String disability);
	List<Adequacy> findAdequacyByType(String type);
	List<Adequacy> findAdequacyByPostalCode(String postalCode);
}
