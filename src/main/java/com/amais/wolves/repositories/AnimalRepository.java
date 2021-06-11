package com.amais.wolves.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amais.wolves.domain.Animal;
import com.amais.wolves.dto.IAnimalDTO;

@Repository
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
public interface AnimalRepository extends JpaRepository<Animal, Integer>, JpaSpecificationExecutor<Animal> {
	
	@Query("select a from Animal a where "
			+ "a.dt_provavel_nasc between ?1 and ?2 "
			+ "and porte in ?3 "
			+ "and sexo in ?4")
	Page<IAnimalDTO> findAllByDobInOneInterval(
			LocalDate from, LocalDate to, 
			List<Short> porte, 
			List<Short> sexo,
			Pageable page);
	
	@Query("select a from Animal a where "
			+ "((a.dt_provavel_nasc between ?1 and ?2) or (a.dt_provavel_nasc between ?3 and ?4)) "
			+ "and porte in ?5 "
			+ "and sexo in ?6")
	Page<IAnimalDTO> findAllByDobInTwoIntervals(
			LocalDate from1, LocalDate to1, 
			LocalDate from2, LocalDate to2, 
			List<Short> porte, 
			List<Short> sexo,
			Pageable page);
	
}
