package Codice;
import Controller.Controller;
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
	
	//GETTER e SETTER
	public String getID_Meeting() {
		return ID_Meeting;
	}
	public void setID_Meeting(String iD_Meeting) {
		ID_Meeting = iD_Meeting;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public Time getOrario() {
		return Orario;
	}
	public void setOrario(Time orario) {
		Orario = orario;
	}
	public Progetto getArgomento() {
		return Argomento;
	}
	public void setArgomento(Progetto argomento) {
		Argomento = argomento;
	}
	
}
