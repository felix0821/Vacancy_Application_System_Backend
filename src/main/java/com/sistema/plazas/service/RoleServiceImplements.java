package com.sistema.plazas.service;
/*
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.plazas.entity.Role;
import com.sistema.plazas.entity.User;
import com.sistema.plazas.exception.CustomeFieldValidationException;
import com.sistema.plazas.exception.RolenameNotFoundException;
import com.sistema.plazas.exception.UsernameOrIdNotFound;
import com.sistema.plazas.repository.RoleRepository;

public class RoleServiceImplements implements RoleService{

	@Autowired
	RoleRepository repository;
	
	public Iterable<Role> getAllRoles() {
		return repository.findAll();
	}
	private boolean checkNameAvailable(Role role) throws Exception {
		Optional<Role> roleFound = repository.findByNameRole2(role.getNameRole());
		if (roleFound.isPresent()) {
			throw new CustomeFieldValidationException("Rolename no disponible","roleName");
		}
		return true;
	}

	@Override
	public Role createRole(Role role) throws Exception {
		if (checkNameAvailable(role)) {
			role = repository.save(role);
		}
		return role;
	}

	@Override
	public Role getRoleById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new RolenameNotFoundException("El Id del rol no existe."));
	}

	@Override
	public Role updateRole(Role role) throws Exception {
		Role toRole = getRoleById(role.getIdRole());
		mapRole(role, toRole);
		return repository.save(toRole);
	}

	private void mapRole(Role from, Role toRole) {
		toRole.setNameRole(from.getNameRole());
		toRole.setDescription(from.getDescription());
		toRole.setState(from.getState());
		toRole.setUserRolCollection(from.getUserRolCollection());
	}
	@Override
	public void deleteRole(Long id) throws Exception {
		Role role = getRoleById(id);
		repository.delete(role);
	}

}
*/
