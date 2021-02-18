package Codice;
import Controller.Controller;
import java.util.ArrayList;

public class Progetto {
	
	//ATTRIBUTI
	public String Titolo;
	public String Tipologia;
	public String Ambito;
	public boolean Attivo;
	public ArrayList<Impiegato> Componenti;
	
	
	//CONSTRUTTORE
	
	public Progetto(String titolo, String tipologia, String ambito) {
		super();
		Titolo = titolo;
		Tipologia = tipologia;
		Ambito = ambito;
		Attivo = true;
	}

	//GETTER E SETTER
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
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
