package DAO;
import Controller.Controller;
import Database.*;
import Codice.Impiegato;

public class ImpiegatoDAO {
	
	
	
	public void add_Impiegato_To_DB (String cF, String nome, String cognome, String mail, String telefono, float salario, Database DB) {
		
		Impiegato p1 = new Impiegato(cF, nome, cognome, mail, telefono, salario);
		
		DB.add_Impiegato(p1);
		
	}
	
}
