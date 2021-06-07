package com.amais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amais.domain.Animal;
import com.amais.repositories.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repo;
	
	public Animal get(Integer id) {
		Animal animal = repo.getById(id);
		return animal;
	}
	
	public List<Animal> findAll() {
		return repo.findAll();
	}
}
