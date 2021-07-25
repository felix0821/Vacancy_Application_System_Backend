package com.sistema.plazas.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	@NotBlank
	private String lastname;
	@NotBlank
	private String lastnameMother;
	@Email(message = "Email should be valid")
	private String email;
	@NotBlank
	private String dni;
	@NotNull
	private Date dateBirth;
	@NotNull
	private Date registrationDate;
	@NotBlank
	private Character state;
	
	public UserDto(@NotBlank String username, @NotBlank String password, @NotBlank String name,
			@NotBlank String lastname, @NotBlank String lastnameMother,
			@Email(message = "Email should be valid") String email, @NotBlank String dni, @NotNull Date dateBirth,
			@NotNull Date registrationDate, @NotBlank Character state) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.lastnameMother = lastnameMother;
		this.email = email;
		this.dni = dni;
		this.dateBirth = dateBirth;
		this.registrationDate = registrationDate;
		this.state = state;
	}

	public UserDto() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastnameMother() {
		return lastnameMother;
	}

	public void setLastnameMother(String lastnameMother) {
		this.lastnameMother = lastnameMother;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Character getState() {
		return state;
	}

	public void setState(Character state) {
		this.state = state;
	}

}
