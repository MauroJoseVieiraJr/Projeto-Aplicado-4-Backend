package com.senai.sc.ProjetoAplicado3.dto.response;

import com.senai.sc.ProjetoAplicado3.entity.Necessity;

public record NecessityResponseDTO(Long id, String disability, String description, String postalCode) {
	public NecessityResponseDTO(Necessity n) {
		this(n.getId(), n.getDisability(), n.getDescription(), n.getPostalCode());
	}
}
