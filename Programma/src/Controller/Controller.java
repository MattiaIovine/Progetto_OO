package Controller;

import javax.swing.JOptionPane;

import Codice.*;
import DAO.*;
import GUI.*;
import Database.*;

import java.util.ArrayList;
public class Controller {
	
	ImpiegatoDAO IDAO= new ImpiegatoDAO();
	MeetingDAO MDAO = new MeetingDAO();
	ProgettoDAO PDAO = new ProgettoDAO();
	SkillDAO SDAO = new SkillDAO();
	Database DB= new Database();
	
	FinestraPrincipale fp;
	GestioneProgetti gp;
	VisualizzaMeeting vm;
	AssunzioneImpiegato ai;
	CreazioneProgetto cp;
	SelezioneImpiegato si;
	SelezionaFiltri sf;
	ProgettiAttivi pa;
	DettagliProgetto dp;
	ProgettiTerminati pt;
	TerminazioneProgetto tp;
	CreaMeeting cm;
	DettagliMeeting dm;

	
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
	public void Vista_Visualizza_Meeting() {
		if(MDAO.get_Meetings_from_DB(DB).size()>0) {
			fp.setVisible(false);
			vm= new VisualizzaMeeting(this, MDAO.get_Meetings_from_DB(DB));
			vm.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(fp, "Non sono stati fissati meeting!", "Attenzione", JOptionPane.WARNING_MESSAGE);
		}
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
		gp.setVisible(true);
	}
	
	public void Vista_Creazione_Progetto() {
		gp.setVisible(false);
		cp= new CreazioneProgetto(this);
		cp.setVisible(true);
	}
	
	public void Vista_Progetti_Attivi() {
		ArrayList<Progetto> progettiattivi = PDAO.get_Progetti_Attivi_From_DB(DB);
		if(progettiattivi.size()>0) {
			pa= new ProgettiAttivi(progettiattivi, this);
			pa.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(gp, "Non sono presenti progetti attivi!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			gp.setVisible(true);
			}
	}
	
	public void Vista_Progetti_Terminati() {
		ArrayList<Progetto> progettiterminati = PDAO.get_Progetti_Terminati_From_DB(DB);
		if(progettiterminati.size()>0) {
			gp.setVisible(false);
			pt= new ProgettiTerminati(progettiterminati, this);
			pt.setVisible(true);
		}
		else {JOptionPane.showMessageDialog(gp, "Non sono presenti progetti terminati!", "Attenzione", JOptionPane.WARNING_MESSAGE);}
	}
	
	public void Vista_Termina_Progetto(Progetto progetto) {
		pa.setVisible(false);
		tp= new TerminazioneProgetto(this, progetto);
		tp.setVisible(true);
	}
	
	public void Torna_Progetti_Attivi() {
		dp.setVisible(false);
		pa.setVisible(true);		
	}
	
	public void Torna_Progetti_Terminati() {
		dp.setVisible(false);
		pt.setVisible(true);
	}
	
	public void Torna_Filtri() {
		si.setVisible(false);
		sf.setVisible(true);		
	}
	
	public void Assumi_Impiegato(String cF, String nome, String cognome, String mail, String telefono, double salario, ArrayList<String> Abilit�) {
		if(!IDAO.isImpiegatoByCF(DB, cF)) {
			JOptionPane.showMessageDialog(fp, "Assunzione effettuata");
		ArrayList<Skill> SkillDiImpiegato=SDAO.add_Skill_To_DB(Abilit�, DB);
		IDAO.add_Impiegato_To_DB(cF, nome, cognome, mail, telefono, salario, SkillDiImpiegato, DB);
		ai.setVisible(false);
		fp.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(ai, "E\' gi� esistente un Impiegato con questo codice fiscale", "Attenzione", JOptionPane.WARNING_MESSAGE);	
		}
	}
	
	public void Crea_Progetto(String Titolo ,String Tipologia, String Ambito) {
		if(PDAO.isProgettoByTitolo(Titolo, DB)) {
			JOptionPane.showMessageDialog(cp, "E\' gi� esistente un Progetto con questo Titolo", "Attenzione", JOptionPane.WARNING_MESSAGE);
		}
		else {
			PDAO.add_Progetto_To_DB(Titolo, Tipologia, Ambito, DB);
			cp.setVisible(false);
			sf= new SelezionaFiltri(SDAO.get_Skills_From_DB(DB), this);
			sf.setVisible(true);
		}
	}
	
	public void getImpiegatibyFiltri(Integer Valutazione, Double Salario, String Ambito, ArrayList<Skill> skillSelezionate) {
		ArrayList<Impiegato> impiegatifiltrati =IDAO.getimpiegatobyfiltri(Valutazione, Salario, Ambito, skillSelezionate, DB);
		if(impiegatifiltrati.size()>1) {
			sf.setVisible(false);
			si=new SelezioneImpiegato(this, impiegatifiltrati);
			si.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(sf, "Non esistono Impiegati appartenenti a questi criteri di ricerca!", "Attenzione", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void RimuoviUltimoProgetto() {
		PDAO.RemoveLastProgetto(DB);
		fp.setVisible(true);
		JOptionPane.showMessageDialog(fp, "Progetto cancellato.","", JOptionPane.PLAIN_MESSAGE);
	}

	public void Aggiungi_Impiegati(ArrayList<Impiegato> scelti) {
		PDAO.Add_Impiegati_to_Progetto_to_DB(scelti, DB);
		si.setVisible(false);
		fp.setVisible(true);
		JOptionPane.showMessageDialog(fp, "Progetto Creato con successo","yay", JOptionPane.PLAIN_MESSAGE);
	}

	public void Termina_Progetto(Progetto progetto, int valutazione) {
		PDAO.Termina_Progetto_in_DB(progetto, valutazione, DB);
		tp.setVisible(false);
		JOptionPane.showMessageDialog(fp, "Progetto terminato correttamente","yay", JOptionPane.PLAIN_MESSAGE);
		this.Vista_Progetti_Attivi();
	}

	public void Visualizza_Dettagli_Progetto(Progetto progetto) {
		pa.setVisible(false);
		dp = new DettagliProgetto(this, progetto);
		dp.setVisible(true);
	}

	public void Crea_Meeting(Progetto progetto) {
		dp.setVisible(false);
		cm= new CreaMeeting(this, progetto);
		cm.setVisible(true);
	}

	public void Crea_Meeting_Telematico(Progetto progetto, String codice_stanza, int anno, int mese, int giorno, int ora, int minuto) {
		MDAO.Organizza_Telematico_to_DB(progetto, codice_stanza, anno, mese, giorno, ora, minuto, DB);
		cm.setVisible(false);
		dp.setVisible(true);
		JOptionPane.showMessageDialog(dp, "Meeting Organizzato.","yay", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void Crea_Meeting_Fisico(Progetto progetto, String sala_riunioni, int anno, int mese, int giorno, int ora, int minuto) {
		MDAO.Organizza_Fisico_to_DB(progetto, sala_riunioni, anno, mese, giorno, ora, minuto, DB);	
		cm.setVisible(false);
		dp.setVisible(true);
		JOptionPane.showMessageDialog(dp, "Meeting Organizzato.","yay", JOptionPane.PLAIN_MESSAGE);
	}

	public void Tieni_Meeting(Meeting meeting) {
		vm.setVisible(false);
		dm = new DettagliMeeting(this, meeting.getPartecipanti(), meeting);
		dm.setVisible(true);
	}

	public void Termina_Meeting(Meeting m, ArrayList<Impiegato> partecipanti) {
		dm.setVisible(false);
		MDAO.Termina_Meeting_in_DB(m, DB);
		fp.setVisible(true);
		
		
	}










}
