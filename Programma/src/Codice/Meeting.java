package Codice;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Calendar;

public class Meeting {
	
	//ATTRIBUTI
	private Calendar Data=Calendar.getInstance();;
	private Progetto Argomento;
	private ArrayList<Impiegato> Partecipanti= new ArrayList<>();
	
	
	//CONSTRUTTORE 
	
	public Meeting(Progetto argomento, int anno, int mese, int giorno, int ora, int minuto) {
		super();
		Data.set(anno, mese, giorno, ora, minuto);
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
}
