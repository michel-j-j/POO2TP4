package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import portsin.LugarDeLectura;
import portsout.EmpleadoRecord;
import portsout.Enviar;
import portsout.InfoException;
import portsout.Lector;

public class Servicio implements LugarDeLectura {

	private Lector lector;
	private List<Empleado> empleados;
	private LocalDate fecha;
	private Enviar enviar;
	public static String FELIZ_CUMPLEANOS = "Feliz Cumpleaños!";

	public Servicio(Lector lector, Enviar enviar, LocalDate fecha) {
		this.lector = Objects.requireNonNull(lector);
		this.empleados = new ArrayList<Empleado>();
		this.fecha = fecha;
		this.enviar = enviar;
	}

	private Empleado cargarEmpleado(EmpleadoRecord empleadoR) {
		return new Empleado(empleadoR.nombre(), empleadoR.apellido(), empleadoR.fecha(), empleadoR.email());
	}

	@Override
	public void leerArchivo() {
		List<EmpleadoRecord> empleadosRecord = lector.listarEmpleados();
		for (EmpleadoRecord empleadoR : empleadosRecord) {
			try {
				empleados.add(cargarEmpleado(empleadoR));
			} catch (InfoException e) {
				System.out.println(e.obtenerMsj());
			}
		}
	}

	@Override
	public void saludarEmpleados() {
		try {
			for (Empleado empleado : empleados) {
				Saludo saludo = new Saludo(empleado);
				if (saludo.saludar())
					enviar.notificarEmpleado(empleado.obtenerNombre(), FELIZ_CUMPLEANOS);
			}
		} catch (InfoException e) {
			System.out.println(e.obtenerMsj());
		}
	}

}
