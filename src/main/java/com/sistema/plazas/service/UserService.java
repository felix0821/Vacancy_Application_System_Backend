package com.sistema.plazas.service;

//import javax.validation.Valid;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sistema.plazas.exception.UsernameOrIdNotFound;

import java.util.List;

import com.sistema.plazas.dto.ChangePasswordForm;
import com.sistema.plazas.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}
