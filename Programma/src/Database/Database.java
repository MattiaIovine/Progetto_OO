package Database;
import java.util.ArrayList;
import Codice.*;
import DAO.*;

public class Database {
	ArrayList<Impiegato> TabellaImpiegati = new ArrayList<>();
	ArrayList<Progetto> TabellaProgetti = new ArrayList<>();
	ArrayList<Meeting> TabellaMeeting = new ArrayList<>();
	ArrayList<Skill> TabellaSkills = new ArrayList<>();
	
	
	
	//METODI
	public void Inizializzazione() {
	Impiegato p1 = new Impiegato("mytg5643", "Mario", "Rossi", "mario.rossi@libero.it","0207654654",1200);
	Impiegato p2 = new Impiegato("uytf6443", "Mattia", "Iovine", "matt.iovine@studenti.unina.it","0810886549",1200);
	Impiegato p3 = new Impiegato("4edxtc43", "Felice", "Esposito", "felice.esposito9@studenti.unina.it","0813246584",1200);
	Impiegato p4 = new Impiegato("nbggt643", "Gabriele", "Belardo", "ga.belardo@studenti.unina.it","0207658874",1200);
	Impiegato p5 = new Impiegato("njhg5643", "Anna", "Verdi", "anna.verdi@libero.it","020765876",1200);
	
	
	TabellaImpiegati.add(p1);
	TabellaImpiegati.add(p2);
	TabellaImpiegati.add(p3);
	TabellaImpiegati.add(p4);
	TabellaImpiegati.add(p5);
	
	}
	
	public void add_Impiegato(Impiegato imp) {
		
		this.TabellaImpiegati.add(imp);
		for (Impiegato i: TabellaImpiegati) {
			System.out.println(i.Mail);
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
