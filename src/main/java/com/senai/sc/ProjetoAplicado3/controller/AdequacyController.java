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

import com.senai.sc.ProjetoAplicado3.dto.request.AdequacyRequestDTO;
import com.senai.sc.ProjetoAplicado3.dto.response.AdequacyResponseDTO;
import com.senai.sc.ProjetoAplicado3.entity.Adequacy;
import com.senai.sc.ProjetoAplicado3.repository.AdequacyRepository;

@RestController
@RequestMapping("ProjetoAplicado3/adequacy")
public class AdequacyController {
	private final AdequacyRepository repository;
	
	public AdequacyController(AdequacyRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/")
	public void post(@RequestBody AdequacyRequestDTO data) {
		Adequacy a = new Adequacy(data);
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/")
	public void put(@RequestBody AdequacyRequestDTO data) {
		Adequacy a = new Adequacy(data);
		
		Adequacy b = repository.getReferenceById(data.id());
		b.update(a.getDisability(), a.getType(), a.getPostalCode());
				
		repository.save(b);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PatchMapping("/")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "disability", required = false) String disability,
						@RequestParam(name = "type", required = false) String type,
						@RequestParam(name = "postalCode", required = false) String postalCode) {
		Adequacy a = repository.getReferenceById(id);
	
		if (disability != null)
			a.setDisability(disability);
		
		if (type != null)
			a.setType(type);
		
		if (postalCode != null)
			a.setPostalCode(postalCode);

		repository.save(a);
	}
	
	@DeleteMapping("/")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/")
	public List<AdequacyResponseDTO> get() {
		List<AdequacyResponseDTO> candidateList = repository.findAll().stream().map(AdequacyResponseDTO::new).toList();
		return candidateList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Adequacy> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Adequacy> n = repository.findById(id);
			
			if (Optional.ofNullable(n).isPresent())
				return new ResponseEntity<Adequacy>(n.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Adequacy>(new Adequacy(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Adequacy>(new Adequacy(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Adequacy>> getByParam(	@RequestParam(name = "disability", required = false) String disability,
														@RequestParam(name = "type", required = false) String type,
														@RequestParam(name = "postalCode", required = false) String postalCode) {
		// A busca aqui tem que ser EXATA
		try {
			List<Adequacy> cDisability = repository.findAdequacyByDisability(disability);
			List<Adequacy> cDescription = repository.findAdequacyByType(type);
			List<Adequacy> cPostalCode = repository.findAdequacyByPostalCode(postalCode);
			List<Adequacy> result = new ArrayList<Adequacy>();
			
			result.addAll(cDisability);
			result.addAll(cDescription);
			result.addAll(cPostalCode);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Adequacy>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Adequacy>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Adequacy>>(HttpStatus.BAD_REQUEST);
		}
	}
}
