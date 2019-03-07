package com.sonerpyci.springdemo.vetsys.dao;

import com.sonerpyci.springdemo.vetsys.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
