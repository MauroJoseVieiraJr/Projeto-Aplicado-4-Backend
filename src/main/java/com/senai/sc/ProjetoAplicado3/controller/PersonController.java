package com.senai.sc.ProjetoAplicado3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sc.ProjetoAplicado3.dto.request.PersonRequestDTO;
import com.senai.sc.ProjetoAplicado3.dto.response.PersonResponseDTO;
import com.senai.sc.ProjetoAplicado3.entity.Person;
import com.senai.sc.ProjetoAplicado3.repository.PersonRepository;

@RestController
@RequestMapping("ProjetoAplicado3/person")
public class PersonController {
	private final PersonRepository repository;
	
	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody PersonRequestDTO data) {
		Person p = new Person(data);
		repository.save(p);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody PersonRequestDTO data) {
		Person p = new Person(data);
		
		Person a = repository.getReferenceById(data.id());
		a.update(p.getName(), p.getSex(), p.getDisability(), p.getTelNumber(), p.getEmail(), p.getPostalCode());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "name", required = false) String name,
						@RequestParam(name = "sex", required = false) String sex,
						@RequestParam(name = "disability", required = false) String disability,
						@RequestParam(name = "telNumber", required = false) String telNumber,
						@RequestParam(name = "email", required = false) String email,
						@RequestParam(name = "postalCode", required = false) String postalCode) {
		Person p = repository.getReferenceById(id);
		
		if (name != null)
			p.setName(name);
				
		if (sex != null)
			p.setSex(sex);
		
		if (disability != null)
			p.setDisability(disability);
		
		if (telNumber != null)
			p.setTelNumber(telNumber);
		
		if (email != null)
			p.setEmail(email);
		
		if (postalCode != null)
			p.setPostalCode(postalCode);

		repository.save(p);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<PersonResponseDTO> get() {
		List<PersonResponseDTO> candidateList = repository.findAll().stream().map(PersonResponseDTO::new).toList();
		return candidateList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Person> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Person> p = repository.findById(id);
			
			if (Optional.ofNullable(p).isPresent())
				return new ResponseEntity<Person>(p.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Person>(new Person(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Person>(new Person(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Person>> getByParam(		@RequestParam(name = "name", required = false) String name,
														@RequestParam(name = "sex", required = false) String sex,
														@RequestParam(name = "disability", required = false) String disability,
														@RequestParam(name = "telNumber", required = false) String telNumber,
														@RequestParam(name = "email", required = false) String email,
														@RequestParam(name = "postalCode", required = false) String postalCode) {
		// A busca aqui tem que ser EXATA
		try {
			List<Person> pName = repository.findCandidateByName(name);
			List<Person> pSex = repository.findCandidateByEmail(sex);
			List<Person> pDisability = repository.findCandidateByEmail(disability);
			List<Person> pTelNumber = repository.findCandidateByEmail(telNumber);
			List<Person> pEmail = repository.findCandidateByEmail(email);
			List<Person> pPostalCode = repository.findCandidateByPostalCode(postalCode);
			List<Person> result = new ArrayList<Person>();
			
			result.addAll(pName);
			result.addAll(pSex);
			result.addAll(pDisability);
			result.addAll(pTelNumber);
			result.addAll(pEmail);
			result.addAll(pPostalCode);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Person>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
	}
}
