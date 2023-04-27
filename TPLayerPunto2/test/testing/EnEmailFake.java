package testing;

import java.util.Objects;

import portsout.Enviar;

public class EnEmailFake implements Enviar {

	private String emisor;
	private String receptor;
	private String usuario;
	private String contra;
	private String host;
	private Boolean enviado;

	public EnEmailFake(String emisor, String receptor, String usuario, String contra, String host) {

		this.emisor = Objects.requireNonNull(emisor);
		this.receptor = Objects.requireNonNull(receptor);
		this.usuario = Objects.requireNonNull(usuario);
		this.contra = Objects.requireNonNull(contra);
		this.host = Objects.requireNonNull(host);
		this.enviado = false;
	}

	@Override
	public void notificarEmpleado(String titulo, String msj) {
		enviado = true;
	}

	@Override
	public Boolean isEnviado() {
		return enviado;
	}

}
