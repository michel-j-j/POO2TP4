package model;

import java.util.Objects;

public class Saludo {
	private Empleado empleado;

	Saludo(Empleado empleado) {
		this.empleado = Objects.requireNonNull(empleado);
	}

	Boolean saludar() {
		return empleado.esTuCumple();
	}
}
