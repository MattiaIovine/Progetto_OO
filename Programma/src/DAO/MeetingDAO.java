package DAO;
import java.util.ArrayList;

import Codice.Fisico;
import Codice.Meeting;
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

	public ArrayList<Meeting> get_Meetings_from_DB(Database DB) {
		return DB.get_Meetings();
	}

	public void Termina_Meeting_in_DB(Meeting m, Database DB) {
		DB.Termina_Meeting(m);		
	}
	
}
