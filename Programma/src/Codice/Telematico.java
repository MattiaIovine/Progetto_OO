package Codice;

public class Telematico extends Meeting{
	

	//ATTRIBUTI
	private String Codice_Stanza;

	public Telematico(Progetto progetto, String codice_stanza, int anno, int mese, int giorno, int ora, int minuto) {
		super(progetto, anno, mese, giorno, ora, minuto);
		Codice_Stanza=codice_stanza;
	}
	
	public String toString() {
		return ("Meeting Telematico      Codice Stanza:"+Codice_Stanza+"             Data: "+this.getData().getTime()+"        Progetto: "+this.getArgomento().getTitolo());
	}
	
	public String getTipo() {
		return "Codice Stanza: "+Codice_Stanza;
	
	}
}