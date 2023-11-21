package com.senai.sc.ProjetoAplicado3.entity;

import com.senai.sc.ProjetoAplicado3.dto.request.AdequacyRequestDTO;

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

@Table(name = "adequacy")
@Entity(name = "adequacy")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adequacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@Column(name = "disability", columnDefinition = "varchar(255) not null")
	private String disability;
	@Column(name = "type", columnDefinition = "varchar(255) not null")
	private String type;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	
	public Adequacy() {}
	
	public Adequacy(AdequacyRequestDTO n) {
		this.disability = n.disability();
		this.type = n.type();
		this.postalCode = n.postalCode();
	}
	
	public void update(String disability, String description, String postalCode) {
		this.disability = disability;
		this.type = description;
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
