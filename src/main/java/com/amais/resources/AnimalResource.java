package com.amais.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amais.domain.Animal;
import com.amais.services.AnimalService;

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
}
