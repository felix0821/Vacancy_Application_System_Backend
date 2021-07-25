package com.sistema.plazas.exception;

public class RolenameNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254360915863178717L;

	public RolenameNotFoundException() {
		super("Nombre de rol no encontrado");
	}
	
	public RolenameNotFoundException(String message) {
		super(message);
	}
}
