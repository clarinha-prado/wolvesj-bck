package com.amais.wolves.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amais.wolves.domain.Animal;
import com.amais.wolves.dto.IAnimalDTO;
import com.amais.wolves.services.AnimalService;

@RestController
@RequestMapping(value="/animais")
public class AnimalResource {

	@Autowired
	private AnimalService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Animal> findByIdAndSituacao(@PathVariable Integer id) {
		Animal animal = service.findById(id);
		return ResponseEntity.ok().body(animal);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> animais = service.findAll();		
		return ResponseEntity.ok().body(animais);
	}
	
	@RequestMapping(value="/ids", method=RequestMethod.GET)
	public ResponseEntity<List<Integer>> findAllIds(){
		List<Integer> ids = service.findAllIds();
		return ResponseEntity.ok().body(ids);
	}
	
	@CrossOrigin
	@RequestMapping(value="/filter", method=RequestMethod.GET)
	public ResponseEntity<Page<IAnimalDTO>> findAllByFilter(
			@RequestParam(value="sizes", defaultValue="0") Integer sizes,
			@RequestParam(value="genders", defaultValue="0") Integer genders,
			@RequestParam(value="ages", defaultValue="0") Integer ages,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="perPage", defaultValue="12") Integer perPage) {
		Page<IAnimalDTO> animais = service.findAllByFilter(sizes, genders, ages, page, perPage);
		
		return ResponseEntity.ok().body(animais);
	}
}
