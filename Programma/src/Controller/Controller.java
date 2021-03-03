package Controller;
import java.awt.Component;

import javax.swing.JOptionPane;

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
	
	FinestraPrincipale fp ;
	GestioneProgetti gp;
	GestioneMeeting gm;
	AssunzioneImpiegato ai;
	CreazioneProgetto cp;
	
	public static void main(String[] args) {
		Controller c = new Controller();		
	}
	
	public Controller() {
		DB.Inizializzazione();
		fp = new FinestraPrincipale(this);
		fp.setVisible(true);
		//Assumi_Impiegato(null, "nuovo", null, null, null, 0);
		//Assumi_Impiegato(null, "funziona",null,null,null,0);
		
	}
	
	//METODI GUI
	
	public void Vista_Gestione_Progetti() {
		fp.setVisible(false);
		gp= new GestioneProgetti(this);
		gp.setVisible(true);
	}
	public void Vista_Gestione_Meeting() {
		fp.setVisible(false);
		gm= new GestioneMeeting(this);
		gm.setVisible(true);
	}
	public void Vista_Assunzione_Impiegato() {
		fp.setVisible(false);
		ai= new AssunzioneImpiegato(this);
		ai.setVisible(true);
	}
	public void Torna_Finestra_Principale() {
		fp.setVisible(true);
	}
	 
	public void Torna_Gestione_Progetto() {
		cp.setVisible(false);
		gp.setVisible(true);
	}
	
	public void Vista_Creazione_Progetto() {
		gp.setVisible(false);
		cp= new CreazioneProgetto(this);
		cp.setVisible(true);
	}
	
	
	
	//METODI CODICE
	
	public void Assumi_Impiegato(String cF, String nome, String cognome, String mail, String telefono, float salario) {
		IDAO.add_Impiegato_To_DB(cF, nome, cognome, mail, telefono, salario, DB);
		ai.setVisible(false);
		fp.setVisible(true);	
	}
	
	public void Crea_Progetto(String Titolo ,String Tipologia, String Ambito) {
		if(PDAO.isProgettoByTitolo(Titolo, DB)) {
			JOptionPane.showMessageDialog(cp, "E\' già esistente un Progetto con questo Titolo", "Attenzione", JOptionPane.WARNING_MESSAGE);
		}
		else {
			PDAO.add_Progetto_To_DB(Titolo, Tipologia, Ambito, DB);
			cp.setVisible(false);
			fp.setVisible(true);
		}
	}
	
	
	
	
	
	
	
	
}
