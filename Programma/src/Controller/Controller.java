package Controller;
import Codice.*;
import DAO.*;
import GUI.*;
import Database.*;

public class Controller {
	
	ImpiegatoDAO IDAO= new ImpiegatoDAO();
	MeetingDAO MDAO = new MeetingDAO();
	ProgettoDAO PDAO = new ProgettoDAO();
	SkillDAO SDAO = new SkillDAO();
	Database DB= new Database();
	
	public static void main(String[] args) {

		Controller c = new Controller();

		
		
	}
	
	public Controller() {
		DB.Inizializzazione();
		
		Assumi_Impiegato(null, "nuovo", null, null, null, 0);
		Assumi_Impiegato(null, "funziona",null,null,null,0);
		
	}
	
	//METODI
	public void Assumi_Impiegato(String cF, String nome, String cognome, String mail, String telefono, float salario) {
		
		IDAO.add_Impiegato_To_DB(cF, nome, cognome, mail, telefono, salario, DB);
	}
	
	
	
	
	
	
	
}
