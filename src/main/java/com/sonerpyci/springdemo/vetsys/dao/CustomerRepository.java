package com.sonerpyci.springdemo.vetsys.dao;


import com.sonerpyci.springdemo.vetsys.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
