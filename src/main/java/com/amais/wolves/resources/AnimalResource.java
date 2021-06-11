package com.amais.wolves.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amais.wolves.domain.Animal;
import com.amais.wolves.dto.IAnimalDTO;
import com.amais.wolves.repositories.AnimalQueryParameters;
import com.amais.wolves.services.AnimalService;

@RestController
@RequestMapping(value="/animais")
public class AnimalResource {

	@Autowired
	private AnimalService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Animal animal = service.get(id);
		return ResponseEntity.ok().body(animal);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Animal> animais = service.findAll();		
		return ResponseEntity.ok().body(animais);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Page<IAnimalDTO>> findAllByFilter(
			@RequestBody AnimalQueryParameters filterForm,
			@RequestParam(value="newPage", defaultValue="0") Integer newPage,
			@RequestParam(value="perPage", defaultValue="12") Integer perPage) {
		Page<IAnimalDTO> animais = service.findAllByFilter(filterForm, newPage, perPage);
		
//		List<Animal> animais = service.findAll();
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("Access-Control-Allow-Origin", "http://localhost:3000");
//		return ResponseEntity.ok().headers(responseHeaders).body(animais);
		
		return ResponseEntity.ok().body(animais);
	}
}
