package model;

import java.util.Objects;

import portsout.ErrorException;

class Telefono {
	
	private String telefono;
	 
	Telefono(String telefono)
	{
		if(telefono.isEmpty())	
			throw new ErrorException("Debe cargar un telefono");
		if(!validarTelefono(telefono))
			throw new ErrorException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
	  	this.telefono = telefono;
	}
	
	String obtenerTelefono(){
		return this.telefono;
	}
	
	private boolean validarTelefono(String telefono) {
	String regex = "\\d{4}-\\d{6}";
	return telefono.matches(regex);
	}
}
