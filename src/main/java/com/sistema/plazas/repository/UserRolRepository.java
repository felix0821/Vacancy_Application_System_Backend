package com.sistema.plazas.repository;

import org.springframework.stereotype.Repository;

import com.sistema.plazas.entity.UserRol;
import com.sistema.plazas.entity.UserRolPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol,UserRolPK>{
	public List<UserRol> findByIdUser(long idUser);
	public List<UserRol> findByIdRole(long idRole);

}
