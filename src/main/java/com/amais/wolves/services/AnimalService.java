package com.amais.wolves.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.amais.util.Logger;
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
	
	public Page<IAnimalDTO> findAllByFilter(AnimalQueryParameters filterForm, Integer newPage, Integer perPage) {
		
		Pageable page = PageRequest.of(newPage, perPage, Direction.DESC, "dt_provavel_nasc");
		
		HashMap<String, LocalDate> dateInterval = filterForm.getAges();
		
		Logger.debug("sizes: " + filterForm.getSizes().toString());
		Logger.debug("genders: " + filterForm.getGenders().toString());
		Logger.debug("date interval: " + dateInterval.get("from1") + " até " + dateInterval.get("to1") );
		
		if (dateInterval.get("from2") == null)
			return repo.findAllByDobInOneInterval(
				dateInterval.get("from1"), dateInterval.get("to1"), 
				filterForm.getSizes(), filterForm.getGenders(),
				page);
		
		else {
			Logger.debug("date interval: " + dateInterval.get("from2") + " até " + dateInterval.get("to2") );
			return repo.findAllByDobInTwoIntervals(
					dateInterval.get("from1"), dateInterval.get("to1"),
					dateInterval.get("from2"), dateInterval.get("to2"), 
					filterForm.getSizes(), filterForm.getGenders(),
					page);
		}
	}
}
