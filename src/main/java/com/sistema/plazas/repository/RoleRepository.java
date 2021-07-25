package com.sistema.plazas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.plazas.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	public Role findByNameRole(String nameRole);
	//public Optional<Role> findByNameRole(String nameRole);
}
