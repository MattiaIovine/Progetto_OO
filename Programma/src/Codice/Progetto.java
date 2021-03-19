package Codice;
import java.util.ArrayList;

public class Progetto {
	
	//ATTRIBUTI
	private String Titolo;
	private String Tipologia;
	private String Ambito;
	private boolean Attivo;
	private ArrayList<Impiegato> Componenti = new ArrayList<>();
	
	
	//CONSTRUTTORE
	
	public Progetto(String titolo, String tipologia, String ambito) {
		super();
		Titolo = titolo;
		Tipologia = tipologia;
		Ambito = ambito;
		Attivo = true;
	}
	
	public String toString() {
		return("Titolo: "+this.Titolo+" -Tipologia: "+this.Tipologia+" -Ambito: "+this.Ambito);
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
	
	public void setAttivo(boolean attivo) {
		Attivo = attivo;
	}
	
	public ArrayList<Impiegato> getComponenti(){
		return this.Componenti;
	}

	public void setComponenti(ArrayList<Impiegato> scelti) {
		for(Impiegato i:scelti) {
			this.Componenti.add(i);
		}	
	}

	public Impiegato getProjectManager() {
		return this.Componenti.get(0);
	}
	
	public ArrayList<Impiegato> getPartecipanti(){
		ArrayList<Impiegato> partecipanti = new ArrayList<>();
		for(Impiegato i:this.Componenti.subList(1,this.Componenti.size())) {
			partecipanti.add(i);
		}
		return partecipanti;
	}
	
}
