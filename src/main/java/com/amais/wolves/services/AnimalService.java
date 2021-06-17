package com.amais.wolves.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
import com.amais.wolves.services.exceptions.ObjectNotFoundException;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repo;
	
	public List<Animal> findAll() {
		return repo.findAll();
	}
	
	public List<Integer> findAllIds() {
		return repo.findAllIds();
	}
	
	public Animal findById(Integer id) {

		Optional<Animal> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Animal.class.getName()));
	}
	
	public Page<IAnimalDTO> findAllByFilter(Integer sizes, Integer genders, Integer ages, Integer newPage, Integer perPage) {
		
		Pageable page = PageRequest.of(newPage, perPage, Direction.DESC, "dt_provavel_nasc");
		
		AnimalQueryParameters queryParams = new AnimalQueryParameters(sizes, genders, ages);
		HashMap<String, LocalDate> dateInterval = queryParams.getAges();
		
		Logger.debug("sizes: " + queryParams.getSizes().toString());
		Logger.debug("genders: " + queryParams.getGenders().toString());
		Logger.debug("date interval: " + dateInterval.get("from1") + " até " + dateInterval.get("to1") );
		
		if (dateInterval.get("from2") == null)
			return repo.findAllByDobInOneInterval(
				dateInterval.get("from1"), dateInterval.get("to1"), 
				queryParams.getSizes(), queryParams.getGenders(),
				page);
		
		else {
			Logger.debug("date interval: " + dateInterval.get("from2") + " até " + dateInterval.get("to2") );
			return repo.findAllByDobInTwoIntervals(
					dateInterval.get("from1"), dateInterval.get("to1"),
					dateInterval.get("from2"), dateInterval.get("to2"), 
					queryParams.getSizes(), queryParams.getGenders(),
					page);
		}
	}
}
