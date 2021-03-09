package Controller;
import java.awt.Component;

import javax.swing.JOptionPane;

import Codice.*;
import DAO.*;
import GUI.*;
import Database.*;


//
import java.util.ArrayList;
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
	SelezioneImpiegato si;
	SelezionaFiltri sf;

	
	public static void main(String[] args) {
		Controller c = new Controller();		
	}
	
	public Controller() {
		DB.Inizializzazione();
		fp = new FinestraPrincipale(this);
		fp.setVisible(true);
	}
	
	//METODI
	
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
	
	public void Assumi_Impiegato(String cF, String nome, String cognome, String mail, String telefono, double salario, ArrayList<String> Abilità) {
		if(!IDAO.isImpiegatoByCF(DB, cF)) {
			JOptionPane.showMessageDialog(ai, "Assunzione effettuata");
		ArrayList<Skill> SkillDiImpiegato=SDAO.add_Skill_To_DB(Abilità, DB);
		IDAO.add_Impiegato_To_DB(cF, nome, cognome, mail, telefono, salario, SkillDiImpiegato, DB);
		ai.setVisible(false);
		fp.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(ai, "E\' già esistente un Impiegato con questo codice fiscale", "Attenzione", JOptionPane.WARNING_MESSAGE);
			
		}
	}
	
	public void Crea_Progetto(String Titolo ,String Tipologia, String Ambito) {
		if(PDAO.isProgettoByTitolo(Titolo, DB)) {
			JOptionPane.showMessageDialog(cp, "E\' già esistente un Progetto con questo Titolo", "Attenzione", JOptionPane.WARNING_MESSAGE);
		}
		else {
			PDAO.add_Progetto_To_DB(Titolo, Tipologia, Ambito, DB);
			cp.setVisible(false);
			sf= new SelezionaFiltri(SDAO.get_Skills_From_DB(DB), this);
			sf.setVisible(true);
		}
	}
	
	public void getImpiegatibyFiltri() {
//		ArrayList<Impiegato> impiegatifiltrati =IDAO.getimpiegatobyfiltri();
		sf.setVisible(false);
//		si=new SelezioneImpiegato(this, impiegatifiltrati);
		si.setVisible(true);
	}
	
	public void RimuoviUltimoProgetto() {
		PDAO.RemoveLastProgetto(DB);
		fp.setVisible(true);
	}
}
