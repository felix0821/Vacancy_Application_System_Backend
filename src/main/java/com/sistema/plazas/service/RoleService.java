package com.sistema.plazas.service;

import com.sistema.plazas.exception.RolenameNotFoundException;
import com.sistema.plazas.entity.Role;

public interface RoleService {

	public Iterable<Role> getAllRoles();

	public Role createRole(Role user) throws Exception;

	public Role getRoleById(Long id) throws Exception;
	
	public Role updateRole(Role user) throws Exception;
	
	public void deleteRole(Long id) throws Exception;
	
}
