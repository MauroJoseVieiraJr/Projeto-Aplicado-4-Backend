package com.senai.sc.ProjetoAplicado3.dto.response;

import com.senai.sc.ProjetoAplicado3.entity.Adequacy;

public record AdequacyResponseDTO(Long id, String disability, String type, String postalCode) {
	public AdequacyResponseDTO(Adequacy a) {
		this(a.getId(), a.getDisability(), a.getType(), a.getPostalCode());
	}
}
