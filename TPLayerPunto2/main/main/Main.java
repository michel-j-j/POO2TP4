package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import data.DeArchivo;
import email.EnEmail;
import model.Servicio;
import portsin.LugarDeLectura;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaFormateada = LocalDate.now().format(formatter);
		LocalDate fecha = LocalDate.parse(fechaFormateada, formatter);

		try {

			LugarDeLectura a = new Servicio(new DeArchivo(), new EnEmail("from@example.com", "tom@example.com",
					"b78c9f4878db7f", "b4f74a52b601e4", "sandbox.smtp.mailtrap.io"), fecha);
			a.leerArchivo();
			a.saludarEmpleados();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
