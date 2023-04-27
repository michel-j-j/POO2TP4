package portsin;

public class RegistroException extends RuntimeException{
	private String msj;
	
	public RegistroException(String msj)
	{
		this.msj = msj;
	}
	
	public String obtenerMsj()
	{
		return msj;
	}
}
