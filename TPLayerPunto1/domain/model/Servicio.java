package model;

import java.util.Objects;

import portsin.Registro;
import portsin.RegistroException;
import portsout.CargarParticipante;
import portsout.ErrorException;

public class Servicio implements Registro {
	CargarParticipante carga;

	public Servicio(CargarParticipante carga) {
		this.carga = Objects.requireNonNull(carga);
	}

	@Override
	public void cargarParticipante(String nombre, String region, String telefono) throws RegistroException {
		try {
			Participante participante = new Participante(nombre, region, telefono);
			carga.almacenarParticipante(participante.cargarRecord());
		} catch (ErrorException e) {
			throw new RegistroException(e.obtenerMsj());
		}
	}

}
