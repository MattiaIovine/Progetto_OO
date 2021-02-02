package Controller;
import Codice.*;
import DAO.*;
import GUI.*;
import Database.*;

public class Controller {
	
	public ImpiegatoDAO IDAO;
	public Database DB;
	
	public static void main(String[] args) {
		
		Database DB= new Database();
		DB.Inizializzazione();
		Controller c = new Controller();
		
		ImpiegatoDAO IDAO = new ImpiegatoDAO();
		c.Assumi_Impiegato(null, "nuovo", null, null, null, 0);
		
		
	}
	
	public Controller() {
		
	}
	
	//METODI
	public void Assumi_Impiegato(String cF, String nome, String cognome, String mail, String telefono, float salario) {
		
		IDAO.add_Impiegato_To_DB(cF, nome, cognome, mail, telefono, salario, DB);
		
	}
	
	
	
	
	
	
	
}
