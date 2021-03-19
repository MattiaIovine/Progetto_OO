package Codice;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Calendar;

public class Meeting {
	
	//ATTRIBUTI
	private Calendar Data=Calendar.getInstance();;
	private Progetto Argomento;
	private boolean Tenuto;
	private ArrayList<Impiegato> Partecipanti= new ArrayList<>();
	
	
	//CONSTRUTTORE 
	
	public Meeting(Progetto argomento, int anno, int mese, int giorno, int ora, int minuto) {
		super();
		Data.set(anno, mese, giorno, ora, minuto);
		Tenuto=false;
		Argomento = argomento;
		for (Impiegato i : Argomento.getComponenti()) {
			Partecipanti.add(i);
		}
	}
	
	
	//GETTER e SETTER
	public Calendar getData() {
		return Data;
	}
	public void setData(Calendar data) {
		Data = data;
	}
	public Progetto getArgomento() {
		return Argomento;
	}
	public void setArgomento(Progetto argomento) {
		Argomento = argomento;
	}
	
	public boolean isTenuto() {
		return Tenuto;
	}
	
	public void setTenuto(boolean tenuto) {
		Tenuto=tenuto;
	}
	
	public String getTipo(){
		return null;
	}
	
	public ArrayList<Impiegato> getPartecipanti(){
		return Partecipanti;
	}
}
