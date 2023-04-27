package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import portsout.InfoException;

public class Fecha {

	private LocalDate fecha;

	Fecha(String fecha) {
		if (fecha.isEmpty())
			throw new InfoException("El fecha esta vacio");
		if (!validarFecha(fecha)) {
			System.out.println(fecha);
			throw new InfoException("El fecha no es valida, deber tener la forma: yyyy/mm/dd");
		}
		this.fecha = formatear(fecha);
	}

	LocalDate obtenerFecha() {
		return this.fecha;
	}

	private Boolean validarFecha(String fecha) {
		String regex = "^\\d{4}/\\d{2}/\\d{2}$";
		String regex2 = "^\\d{4}-\\d{2}-\\d{2}$";

		return fecha.matches(regex) || fecha.matches(regex2);
	}

	LocalDate formatear(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		try {
			return LocalDate.parse(fecha, formatter);
		} catch (Exception e) {
			return LocalDate.parse(parsearFecha(fecha), formatter);
		}
	}

	private Boolean compararFecha(Fecha fecha) {

		if (this.fecha.equals(fecha.obtenerFecha()))
			return true;

		return false;
	}

	String parsearFecha(String fecha) {

		LocalDate fechaParse = LocalDate.parse(fecha);
		return fechaParse.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

	}

}
