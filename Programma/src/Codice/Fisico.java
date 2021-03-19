package Codice;

import java.sql.Time;
import java.util.Date;

public class Fisico extends Meeting {
	
	//ATTRIBUTI
	public String Sala_Riunioni;

	public Fisico(Progetto progetto, String sala_riunioni, int anno, int mese, int giorno, int ora, int minuto) {
		super(progetto, anno, mese, giorno, ora, minuto);
		Sala_Riunioni=sala_riunioni;
	}
	
	public String toString() { 
		return ("Meeting Fisico               Sala Riunioni:"+Sala_Riunioni+"               Data: "+this.getData().getTime()+"         Progetto: "+this.getArgomento().getTitolo());
	} 
	
	public String getTipo() {
		return "Sala Riunioni: "+Sala_Riunioni;
	}
}




