package DAO;
import Controller.Controller;
import Database.*;
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
}
