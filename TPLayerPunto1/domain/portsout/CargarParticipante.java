package portsout;

import java.sql.SQLException;

public interface CargarParticipante{
	public void almacenarParticipante(ParticipanteRecord participante) throws ErrorException;
}
