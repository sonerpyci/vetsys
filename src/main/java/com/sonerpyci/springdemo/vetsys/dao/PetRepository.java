package com.sonerpyci.springdemo.vetsys.dao;

import com.sonerpyci.springdemo.vetsys.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
