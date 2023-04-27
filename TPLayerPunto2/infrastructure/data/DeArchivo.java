package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import portsout.EmpleadoRecord;
import portsout.Lector;

public class DeArchivo implements Lector {

	@Override
	public List<EmpleadoRecord> listarEmpleados() {
		List<EmpleadoRecord> empleados = new ArrayList<EmpleadoRecord>();
		String rutaArchivo = "resources/Empleados"; // Reemplaza con la ruta correcta de tu archivo
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] textos = linea.split(", ");
				List<String> datos = new ArrayList<String>();
				for (String texto : textos) {
					datos.add(texto.trim());

				}
				empleados.add(armarEmpleadoRecord(datos));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return empleados;
	}

	private EmpleadoRecord armarEmpleadoRecord(List<String> datos) {
		return new EmpleadoRecord(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
	}
}
