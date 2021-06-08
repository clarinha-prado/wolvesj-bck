package com.amais.wolves.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amais.wolves.domain.Animal;

@Repository
// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	List<Animal> findAllByPorteIn(List<Short> porte);
}
