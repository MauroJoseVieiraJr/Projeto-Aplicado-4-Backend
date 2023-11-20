package com.senai.sc.ProjetoAplicado3.entity;

import com.senai.sc.ProjetoAplicado3.dto.request.PersonRequestDTO;

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
	@Column(name = "name", columnDefinition = "varchar(255) not null")
	private String name;
	@Column(name = "sex", columnDefinition = "varchar(255) not null")
	private String sex;
	@Column(name = "disability", columnDefinition = "varchar(255) not null")
	private String disability;
	@Column(name = "tel_number", columnDefinition = "varchar(255) not null")
	private String telNumber;
	@Column(name = "email", columnDefinition = "varchar(255) not null")
	private String email;
	@Column(name = "postal_code", columnDefinition = "varchar(255) not null")
	private String postalCode;
	
	public Necessity() {}
	
	public Necessity(PersonRequestDTO c) {
		this.name = c.name();
		this.sex = c.sex();
		this.disability = c.disability();
		this.telNumber = c.telNumber();
		this.email = c.email();
		this.postalCode = c.postalCode();
	}
	
	public void update(String name, String sex, String disability, String telNumber, String email, String postalCode) {
		this.name = name;
		this.sex = sex;
		this.disability = disability;
		this.telNumber = telNumber;
		this.email = email;
		this.postalCode = postalCode;
	}
}
