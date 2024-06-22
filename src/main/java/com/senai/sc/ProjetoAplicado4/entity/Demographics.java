package com.senai.sc.ProjetoAplicado4.entity;

import com.senai.sc.ProjetoAplicado4.dto.request.AdequacyRequestDTO;
import com.senai.sc.ProjetoAplicado4.dto.request.NecessityRequestDTO;
import com.senai.sc.ProjetoAplicado4.dto.request.PersonRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * A ideia da classe Demographics é de extrair as informações relevantes das classes
 * Person, Necessity e Adequacy para então ser processada pela DataMap e gerar um relatório
 * por ela.
 */
@Table(name = "demographics")
@Entity(name = "demographics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Demographics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@Column(name = "sex", columnDefinition = "varchar(255) not null")
	private String sex;
	@Column(name = "disability", columnDefinition = "varchar(255) not null")
	private String disability;
	@Column(name = "necessity", columnDefinition = "varchar(255) not null")
	private String necessity;
	@Column(name = "adequacy", columnDefinition = "varchar(255) not null")
	private String adequacy;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	
	public Demographics() {}
	
	// Uma Pessoa tem uma Necessidade de Adequação
	public Demographics(PersonRequestDTO p, NecessityRequestDTO n, AdequacyRequestDTO a) {
		this.sex = p.sex();
		this.necessity = n.description();
		this.adequacy = a.type();
		this.postalCode = p.postalCode();
	}
	
	// Quero unir pessoas, necessidades e adequações pelo critério deficiência
	// Quero unir pessoas, necessidades e adequações pelo CEP
}
