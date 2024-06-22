package com.senai.sc.ProjetoAplicado4.dto.response;

import com.senai.sc.ProjetoAplicado4.entity.Person;

public record PersonResponseDTO(Long id, String name, String sex, String disability, String telNumber, String email, String postalCode) {
	public PersonResponseDTO (Person c) {
		this(c.getId(), c.getName(), c.getSex(), c.getDisability(), c.getTelNumber(), c.getEmail(), c.getPostalCode());
	}
}
