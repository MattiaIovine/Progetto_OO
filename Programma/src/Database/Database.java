package Database;
import java.util.ArrayList;
import Codice.*;
import DAO.*;

public class Database {
	public ArrayList<Impiegato> TabellaImpiegati;
	public ArrayList<Progetto> TabellaProgetti;
	public ArrayList<Meeting> TabellaMeeting;
	public ArrayList<Skill> TabellaSkills;
	
	public Database() {
		
	}
	
	//METODI
	public void Inizializzazione() {
	Impiegato p1 = new Impiegato("mytg5643", "Mario", "Rossi", "mario.rossilibero.it","0207654654",1200);
	Impiegato p2 = new Impiegato("uytf6443", "Mattia", "Iovine", "matt.iovinestudenti.unina.it","0810886549",1200);
	Impiegato p3 = new Impiegato("4edxtc43", "Felice", "Esposito", "felice.esposito9studenti.unina.it","0813246584",1200);
	Impiegato p4 = new Impiegato("nbggt643", "Gabriele", "Belardo", "ga.belardostudenti.unina.it","0207658874",1200);
	Impiegato p5 = new Impiegato("njhg5643", "Anna", "Verdi", "anna.verdilibero.it","020765876",1200);
	
	
	ArrayList<Impiegato>TabellaImpiegati = new ArrayList<>();	
	
	TabellaImpiegati.add(p1);
	TabellaImpiegati.add(p2);
	TabellaImpiegati.add(p3);
	TabellaImpiegati.add(p4);
	TabellaImpiegati.add(p5);
	
	
//	ArrayList<Progetto>TabellaProgetti = new ArrayList<>();	
//	ArrayList<Meeting>TabellaMeeting = new ArrayList<>();	
//	ArrayList<Skill>TabellaSkills = new ArrayList<>();	
		
	}
	
	public void add_Impiegato(Impiegato imp) {
		
		this.TabellaImpiegati.add(imp);
		for (Impiegato i: TabellaImpiegati) {
			System.out.println(i.Nome);
		}
	}
	
	public void add_Progetto(Progetto pro) {
		
		this.TabellaProgetti.add(pro);
	}

	public void add_Meeting(Meeting mee) {
	
		this.TabellaMeeting.add(mee);
	}
	
	public void add_Skill(Skill ski) {
		
		this.TabellaSkills.add(ski);
	}
	
}
