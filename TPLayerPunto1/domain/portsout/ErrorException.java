package portsout;

public class ErrorException extends RuntimeException{
	private String msj;
	
	public ErrorException(String msj)
	{
		this.msj = msj;
	}

	public String obtenerMsj()
	{
		return this.msj;
	}
}
