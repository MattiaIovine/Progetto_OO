package Codice;

import java.sql.Time;
import java.util.Date;

public class Telematico extends Meeting{
	

	//ATTRIBUTI
	public String Codice_Stanza;
	
	
	
	
	public Telematico(String iD_Meeting, Date data, Time orario, Progetto argomento , String cod_stanza) {
		super(iD_Meeting, data, orario, argomento);
		Codice_Stanza = cod_stanza;
		// TODO Auto-generated constructor stub
	}

}