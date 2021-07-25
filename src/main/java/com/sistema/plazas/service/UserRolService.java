package com.sistema.plazas.service;

import com.sistema.plazas.entity.UserRol;

public interface UserRolService {
	public UserRol createUserRol(UserRol userRol) throws Exception;
	public void deleteUserRol(Long idUser, long idRole) throws Exception;
	
}
