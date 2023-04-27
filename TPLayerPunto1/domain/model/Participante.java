package model;

import java.util.Objects;

import portsout.ErrorException;
import portsout.ParticipanteRecord;

public class Participante {
	String nombre;
	String region;
	String telefono;

	Participante(String nombre, String region, String telefono) {
		if (nombre.isEmpty())
			throw new ErrorException("Debe cargar un nombre");

		this.nombre = Objects.requireNonNull(nombre);
		this.region = new Region(region).obtenerRegion();
		this.telefono = new Telefono(telefono).obtenerTelefono();
	}

	ParticipanteRecord cargarRecord() {
		return new ParticipanteRecord(nombre, region, telefono);
	}
}
