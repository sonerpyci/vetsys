package com.sonerpyci.springdemo.vetsys.services;

import com.sonerpyci.springdemo.vetsys.dao.CustomerRepository;
import com.sonerpyci.springdemo.vetsys.dao.PetRepository;
import com.sonerpyci.springdemo.vetsys.models.Customer;
import com.sonerpyci.springdemo.vetsys.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EntityManager entityManager;

    /* PET MODEL OPERATIONS */
    public Collection<Pet> findAllPets(){
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : petRepository.findAll()) {
            pets.add(pet);
        }
        return pets;
    }

    public Pet findPetById(long id){
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElse(null);
    }


    public void deletePet(long id){
        petRepository.deleteById(id);
    }

    public void savePet(Pet pet){
        petRepository.save(pet);
        System.out.println();
    }

    public List findPetsByOwnerId(Long id) {
        List pets = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT u FROM pet u WHERE u.owner=:owner");
        query.setParameter("owner", id);
        try {
            pets = query.getResultList();
        } catch (Exception e) {
            // Handle exception
        }
        return pets;
    }

    public List findPetsBySearch(String searchQuery) {
        List petSearchResult = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT p,c FROM pet As p JOIN customer AS c ON p.owner = c.id  WHERE p.name LIKE:searchQuery");
        query.setParameter("searchQuery", '%'+searchQuery+'%');
        try {
            petSearchResult = query.getResultList();
            System.out.println();
        } catch (Exception e) {
            // Handle exception
        }
        return petSearchResult;
    }

}
