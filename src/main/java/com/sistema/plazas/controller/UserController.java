package com.sistema.plazas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.plazas.entity.User;
import com.sistema.plazas.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
    public ResponseEntity<Iterable<User>> list(){
		Iterable<User> list = userService.getAllUsers();
        return new ResponseEntity<Iterable<User>>(list, HttpStatus.OK);
    }

}
