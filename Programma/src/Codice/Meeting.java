package Codice;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Meeting {
	
	//ATTRIBUTI
	public String   ID_Meeting;
	public Date     Data;
	public Time     Orario;
	public Progetto Argomento;
	public ArrayList<Persona> Partecipanti;
	
}
