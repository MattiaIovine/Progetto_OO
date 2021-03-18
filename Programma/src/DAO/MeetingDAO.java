package DAO;
import Codice.Fisico;
import Codice.Progetto;
import Codice.Telematico;
import Database.*;


public class MeetingDAO {

	public void Organizza_Telematico_to_DB(Progetto progetto, String codice_stanza, int anno, int mese, int giorno, int ora, int minuto, Database DB) {
		Telematico p1 = new Telematico(progetto, codice_stanza, anno, mese, giorno, ora, minuto);
		DB.add_Meeting(p1);
	}

	public void Organizza_Fisico_to_DB(Progetto progetto, String sala_riunioni, int anno, int mese, int giorno, int ora, int minuto, Database DB) {
		Fisico p1 = new Fisico(progetto, sala_riunioni, anno, mese, giorno, ora, minuto);
		DB.add_Meeting(p1);
	}
	
}
