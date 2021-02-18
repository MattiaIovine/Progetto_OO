package Codice;
import Controller.Controller;
import java.util.ArrayList;

public class Progetto {
	
	//ATTRIBUTI
	public String Titolo_Progetto;
	public String Tipologia;
	public String Ambito;
	public boolean Attivo;
	public ArrayList<Impiegato> Componenti;
	
	
	//CONSTRUTTORE
	
	public Progetto(String iD_Progetto, String tipologia, String ambito) {
		super();
		Titolo_Progetto = iD_Progetto;
		Tipologia = tipologia;
		Ambito = ambito;
		Attivo = true;
	}

	//GETTER E SETTER
	public String getID_Progetto() {
		return Titolo_Progetto;
	}
	public void setID_Progetto(String iD_Progetto) {
		Titolo_Progetto = iD_Progetto;
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

	public boolean isAttivo() {
		return Attivo;
	}
	
	public void setAttivo_false() {
		Attivo = false;
	}
}
