package com.amais.wolves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amais.wolves.domain.Animal;
import com.amais.wolves.repositories.AnimalRepository;

import com.amais.wolves.repositories.AnimalQueryParameters;

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
	
	public List<Animal> findAllByFilter(AnimalQueryParameters filterForm) {
		System.out.println("oiê :)  --->" + filterForm.getSizes().toString());
		return repo.findAllByPorteIn(filterForm.getSizes());
	}
}
