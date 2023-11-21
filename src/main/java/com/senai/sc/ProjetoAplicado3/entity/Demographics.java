package com.senai.sc.ProjetoAplicado3.entity;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senai.sc.ProjetoAplicado3.dto.request.AdequacyRequestDTO;
import com.senai.sc.ProjetoAplicado3.dto.request.NecessityRequestDTO;
import com.senai.sc.ProjetoAplicado3.dto.request.PersonRequestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private Long id;
	
	@OneToMany(targetEntity = Person.class, cascade = CascadeType.ALL)
	private ArrayList<Person> people;
	@OneToMany(targetEntity = Necessity.class, cascade = CascadeType.ALL)
	private ArrayList<Necessity> necessities;
	@OneToMany(targetEntity = Adequacy.class, cascade = CascadeType.ALL)
	private ArrayList<Adequacy> adequacies;
	
	private String sex;
	
	private String disability;
	
	private String necessity;
	
	private String adequacy;
	
	private String postalCode;
	
	public Demographics() {}
	
	// Uma Pessoa tem uma Necessidade de Adequação
	public Demographics(PersonRequestDTO p, NecessityRequestDTO n, AdequacyRequestDTO a) {
		this.sex = p.sex();
		// Garantir que as deficiências sejam as mesmas
		if (p.disability() == n.disability() && n.disability() == a.disability() && p.disability() == a.disability())
			this.disability = p.disability();
		this.necessity = n.description();
		this.adequacy = a.type();
		// Garantir que os códigos postais sejam os mesmos
		if (p.postalCode() == n.postalCode() && n.postalCode() == a.postalCode() && p.postalCode() == a.postalCode())
			this.postalCode = p.postalCode();
	}
	
	// Quero unir pessoas, necessidades e adequações pelo critério deficiência
	// Quero unir pessoas, necessidades e adequações pelo CEP
	
	public void test() {
		JdbcTemplate j = new JdbcTemplate();
		
		int result = j.queryForObject("SELECT COUNT(*) FROM Person", Integer.class);
		
		System.out.println(result);
		
		// Ordem de person ficou: id, disability, email, name, postal_code, sex, tel_number
	}
}
