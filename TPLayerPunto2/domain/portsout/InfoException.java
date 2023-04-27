package portsout;

public class InfoException extends RuntimeException {
	private String msj;

	public InfoException(String msj) {
		this.msj = msj;
	}

	public String obtenerMsj() {
		return this.msj;
	}
}
