package com.amais.wolves.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amais.wolves.domain.Animal;
import com.amais.wolves.dto.IAnimalDTO;
import com.amais.wolves.repositories.AnimalQueryParameters;
import com.amais.wolves.repositories.AnimalRepository;

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
	
	public List<IAnimalDTO> findAllByFilter(AnimalQueryParameters filterForm) {
		
		HashMap<String, LocalDate> dateInterval = filterForm.getAges();
		final Logger logger = LogManager.getLogger("HelloWorld");
		
		logger.error("sizes: " + filterForm.getSizes().toString());
		logger.error("genders: " + filterForm.getGenders().toString());
		logger.error("date interval: " + dateInterval.get("from1") + " até " + dateInterval.get("to1") );
		
		if (dateInterval.get("from2") == null)
			return repo.findAllByDobInOneInterval(
				dateInterval.get("from1"), dateInterval.get("to1"), 
				filterForm.getSizes(), filterForm.getGenders());
		
		else {
			logger.error("date interval: " + dateInterval.get("from2") + " até " + dateInterval.get("to2") );
			return repo.findAllByDobInTwoIntervals(
					dateInterval.get("from1"), dateInterval.get("to1"),
					dateInterval.get("from2"), dateInterval.get("to2"), 
					filterForm.getSizes(), filterForm.getGenders());
		}
	}
}
