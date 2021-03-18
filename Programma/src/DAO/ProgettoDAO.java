package DAO;
import Database.*;

import java.util.ArrayList;

import Codice.Impiegato;
import Codice.Progetto;

public class ProgettoDAO {

	public boolean isProgettoByTitolo(String Titolo, Database DB){
		return DB.ProgettoByTitolo(Titolo);
	}
	
	public void add_Progetto_To_DB(String Titolo, String Tipologia, String Ambito, Database DB) {
		Progetto p1 = new Progetto(Titolo, Tipologia, Ambito);
		DB.add_Progetto(p1);
	}

	public void RemoveLastProgetto(Database DB) {
		DB.RimuoviUltimoProgetto();
	}

	public void Add_Impiegati_to_Progetto_to_DB(ArrayList<Impiegato> scelti, Database DB) {
		DB.Add_Impiegati_to_Progetto(scelti);
	}

	public ArrayList<Progetto> get_Progetti_Attivi_From_DB(Database DB) {
		return DB.get_Progetti_Attivi();
	}
	
	public ArrayList<Progetto> get_Progetti_Terminati_From_DB(Database DB) {
		return DB.get_Progetti_Terminati();
	}

	public void Termina_Progetto_in_DB(Progetto progetto, int valutazione, Database DB) {
		DB.Termina_Progetto(progetto, valutazione);
	}
}
