package com.senai.sc.ProjetoAplicado3.entity;

import com.senai.sc.ProjetoAplicado3.dto.request.NecessityRequestDTO;

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

@Table(name = "necessity")
@Entity(name = "necessity")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Necessity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	@Column(name = "disability", columnDefinition = "varchar(255) not null")
	private String disability;
	@Column(name = "description", columnDefinition = "varchar(255) not null")
	private String description;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	
	public Necessity() {}
	
	public Necessity(NecessityRequestDTO n) {
		this.disability = n.disability();
		this.description = n.description();
		this.postalCode = n.postalCode();
	}
	
	public void update(String disability, String description, String postalCode) {
		this.disability = disability;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
