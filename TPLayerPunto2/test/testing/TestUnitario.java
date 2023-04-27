package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import data.DeArchivo;
import model.Servicio;
import portsin.LugarDeLectura;

public class TestUnitario {

	@Test
	public void SaludarPorCumpleaños() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaFormateada = LocalDate.now().format(formatter);
		LocalDate fecha = LocalDate.parse(fechaFormateada, formatter);

		try {
			var notificar = new EnEmailFake("from@example.com", "tom@example.com", "b78c9f4878db7f", "b4f74a52b601e4",
					"sandbox.smtp.mailtrap.io");
			LugarDeLectura a = new Servicio(new DeArchivo(), notificar, fecha);
			a.leerArchivo();
			a.saludarEmpleados();
			assertEquals(true, notificar.isEnviado());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
