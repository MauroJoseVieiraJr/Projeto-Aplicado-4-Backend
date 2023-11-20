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

@Table(name = "person")
@Entity(name = "person")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {
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
	
	public Person() {}
	
	public Person(PersonRequestDTO c) {
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
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getDisability() {
		return disability;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPostalCode() {
		return postalCode;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
