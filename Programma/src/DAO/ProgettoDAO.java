package DAO;
import Database.*;

import java.util.ArrayList;

import Codice.Impiegato;
import Codice.Progetto;

public class ProgettoDAO {

	public boolean is_Progetto_By_Titolo(String titolo, Database DB){
		return DB.ProgettoByTitolo(titolo);
	}
	
	public void add_Progetto_To_DB(String titolo, String tipologia, String ambito, Database DB) {
		Progetto p1 = new Progetto(titolo, tipologia, ambito);
		DB.add_Progetto(p1);
	}

	public void Rimuovi_Ultimo_Progetto_In_DB(Database DB) {
		DB.RimuoviUltimoProgetto();
	}

	public void add_Impiegati_To_Progetto_To_DB(ArrayList<Impiegato> scelti, Database DB) {
		DB.Add_Impiegati_to_Progetto(scelti);
	}

	public ArrayList<Progetto> get_Progetti_Attivi_From_DB(Database DB) {
		return DB.get_Progetti_Attivi();
	}
	
	public ArrayList<Progetto> get_Progetti_Terminati_From_DB(Database DB) {
		return DB.get_Progetti_Terminati();
	}

	public void Termina_Progetto_In_DB(Progetto progetto, int valutazione, Database DB) {
		DB.Termina_Progetto(progetto, valutazione);
	}
}
