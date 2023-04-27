package model;

import portsout.InfoException;

public class Email {
	private String email;

	Email(String email) {
		if (email.isEmpty())
			throw new InfoException("El email esta vacio");
		if (!validarEmail(email))
			throw new InfoException("El email no es valido, deber tener la forma: abc@123.com");

		this.email = email;

	}

	String obtenerEmail() {
		return this.email;
	}

	Boolean validarEmail(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}
}
