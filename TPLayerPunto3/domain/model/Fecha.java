package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import portsout.InfoException;

public class Fecha {

	private LocalDate fecha;

	Fecha(String fecha) {
		if (fecha.isEmpty())
			throw new InfoException("La fecha esta vacio");
		if (!validarFecha(fecha))
			throw new InfoException("Formato de la fecha invalido, el formato debe ser yyyy/MM/dd");
		this.fecha = formatear(fecha);
	}

	Fecha(LocalDate inicio, LocalDate fin) {
		if (!fechaValida(inicio, fin))
			throw new InfoException("Fecha invalida");
	}

	LocalDate obtenerFecha() {
		return this.fecha;
	}

	LocalDate formatear(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // El formato deseado
		return LocalDate.parse(fecha, formatter);
	}

	private Boolean validarFecha(String fecha) {

		String regex = "\\d{4}/\\d{2}/\\d{2}";
		return fecha.matches(regex);
	}

	private Boolean fechaValida(LocalDate inicio, LocalDate fin) { // dos contructors
		LocalDate hoy = LocalDate.now();
		return (hoy.isAfter(inicio) || hoy.equals(hoy)) && (hoy.isBefore(fin) || hoy.equals(fin));
	}

}
