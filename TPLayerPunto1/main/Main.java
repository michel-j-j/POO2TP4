import data.ParticipanteJDBC;
import model.Servicio;
import ui.VentanaPrincipal;

public class Main {
	public static void main(String[] args) {
		new VentanaPrincipal(new Servicio(new ParticipanteJDBC()));
	}
}
