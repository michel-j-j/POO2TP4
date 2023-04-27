package model;

import java.time.LocalDate;

import portsout.InfoException;

public class Concurso {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Concurso(String nombre, String fechaInicio, String fechaFin) {
		if (nombre.isEmpty())
			throw new InfoException("Ingrese un nombre");

		this.nombre = nombre;
		this.fechaInicio = new Fecha(fechaInicio).obtenerFecha();
		this.fechaFin = new Fecha(fechaFin).obtenerFecha();
	}

	void inscripcionAbierta() {
		new Fecha(fechaInicio, fechaFin);
	}
}
