package DAO;
import java.util.ArrayList;

import Codice.Fisico;
import Codice.Meeting;
import Codice.Progetto;
import Codice.Telematico;
import Database.*;


public class MeetingDAO {

	public void Organizza_Telematico_To_DB(Progetto progetto, String codice_stanza, int anno, int mese, int giorno, int ora, int minuto, Database DB) {
		Telematico p1 = new Telematico(progetto, codice_stanza, anno, mese, giorno, ora, minuto);
		DB.add_Meeting(p1);
	}

	public void Organizza_Fisico_To_DB(Progetto progetto, String sala_riunioni, int anno, int mese, int giorno, int ora, int minuto, Database DB) {
		Fisico p1 = new Fisico(progetto, sala_riunioni, anno, mese, giorno, ora, minuto);
		DB.add_Meeting(p1);
	}

	public ArrayList<Meeting> get_Meetings_From_DB(Database DB) {
		return DB.get_Meetings();
	}

	public void Termina_Meeting_In_DB(Meeting m, Database DB) {
		DB.Termina_Meeting(m);		
	}

	public void Termina_Meeting_Di_Progetto_In_DB(Progetto progetto, Database DB) {
		DB.Termina_Meeting_Di_Progetto(progetto);
	}
	
}
