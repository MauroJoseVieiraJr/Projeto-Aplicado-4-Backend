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

import com.senai.sc.ProjetoAplicado3.dto.request.NecessityRequestDTO;
import com.senai.sc.ProjetoAplicado3.dto.response.NecessityResponseDTO;
import com.senai.sc.ProjetoAplicado3.entity.Necessity;
import com.senai.sc.ProjetoAplicado3.repository.NecessityRepository;

@RestController
@RequestMapping("ProjetoAplicado3/necessity")
public class NecessityController {
	private final NecessityRepository repository;
	
	public NecessityController(NecessityRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/post")
	public void post(@RequestBody NecessityRequestDTO data) {
		Necessity n = new Necessity(data);
		repository.save(n);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/put")
	public void put(@RequestBody NecessityRequestDTO data) {
		Necessity n = new Necessity(data);
		
		Necessity a = repository.getReferenceById(data.id());
		a.update(n.getDisability(), n.getDescription(), n.getPostalCode());
				
		repository.save(a);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PatchMapping("/patch")
	public void patch(	@RequestParam(name = "id", required = true) long id,
						@RequestParam(name = "disability", required = false) String disability,
						@RequestParam(name = "description", required = false) String description,
						@RequestParam(name = "postalCode", required = false) String postalCode) {
		Necessity n = repository.getReferenceById(id);
	
		if (disability != null)
			n.setDisability(disability);
		
		if (description != null)
			n.setDescription(description);
		
		if (postalCode != null)
			n.setPostalCode(postalCode);

		repository.save(n);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {	
		repository.deleteById(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/get")
	public List<NecessityResponseDTO> get() {
		List<NecessityResponseDTO> candidateList = repository.findAll().stream().map(NecessityResponseDTO::new).toList();
		return candidateList;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyid")
	public ResponseEntity<Necessity> getById(@RequestParam(name = "id", required = true) long id) {
		try {
			Optional<Necessity> n = repository.findById(id);
			
			if (Optional.ofNullable(n).isPresent())
				return new ResponseEntity<Necessity>(n.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Necessity>(new Necessity(), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Necessity>(new Necessity(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getbyparam")
	public ResponseEntity<List<Necessity>> getByParam(	@RequestParam(name = "disability", required = false) String disability,
														@RequestParam(name = "description", required = false) String description,
														@RequestParam(name = "postalCode", required = false) String postalCode) {
		// A busca aqui tem que ser EXATA
		try {
			List<Necessity> cDisability = repository.findCandidateByDisability(disability);
			List<Necessity> cDescription = repository.findCandidateByDescription(description);
			List<Necessity> cPostalCode = repository.findCandidateByPostalCode(postalCode);
			List<Necessity> result = new ArrayList<Necessity>();
			
			result.addAll(cDisability);
			result.addAll(cDescription);
			result.addAll(cPostalCode);
			
			if (!result.isEmpty())
				return new ResponseEntity<List<Necessity>>(result, HttpStatus.OK);
			else
				return new ResponseEntity<List<Necessity>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<Necessity>>(HttpStatus.BAD_REQUEST);
		}
	}
}
