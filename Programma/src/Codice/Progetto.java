package Codice;
import java.util.ArrayList;

public class Progetto {
	
	//ATTRIBUTI
	public String ID_Progetto;
	public String Tipologia;
	public String Ambito;
	public ArrayList<Persona> Componenti;
	//GETTER E SETTER
	public String getID_Progetto() {
		return ID_Progetto;
	}
	public void setID_Progetto(String iD_Progetto) {
		ID_Progetto = iD_Progetto;
	}
	public String getTipologia() {
		return Tipologia;
	}
	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}
	public String getAmbito() {
		return Ambito;
	}
	public void setAmbito(String ambito) {
		Ambito = ambito;
	}



}
