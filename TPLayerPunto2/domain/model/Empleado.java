package model;

import java.time.LocalDate;

import portsout.EmpleadoRecord;
import portsout.InfoException;

public class Empleado {
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fecha;

	Empleado(String nombre, String apellido, String fecha, String email) {
		if (nombre.isEmpty())
			throw new InfoException("El nombre esta vacio");
		if (apellido.isEmpty())
			throw new InfoException("El apellido esta vacio");

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = new Email(email).obtenerEmail();
		this.fecha = new Fecha(fecha).obtenerFecha();
	}

	Boolean esTuCumple() {
		LocalDate hoy = LocalDate.now();
		if (fecha.equals(hoy))
			return true;
		return false;
	}

	// Preguntar por cumplleaños
	String obtenerNombre() {
		return this.nombre;
	}

	EmpleadoRecord cargarRecord() {
		return new EmpleadoRecord(nombre, apellido, fecha.toString(), email);
	}
}
