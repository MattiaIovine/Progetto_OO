package Codice;

import java.sql.Time;
import java.util.Date;

public class Fisico extends Meeting {
	
	//ATTRIBUTI
	public String Sala_Riunioni;
	
	
	
	public Fisico(String iD_Meeting, Date data, Time orario, Progetto argomento, String sala) {
		super(iD_Meeting, data, orario, argomento);
		Sala_Riunioni= sala;
	}
}




