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
	
	Skill s1= new Skill("skill1");
	Skill s2= new Skill("skill2");
	Skill s3= new Skill("skill3");
	Skill s4= new Skill("skill4");
	
	p1.addSkill(s1);
	p2.addSkill(s4);	p2.addSkill(s3);
	p3.addSkill(s2);
	p4.addSkill(s1);	p4.addSkill(s3);
	p5.addSkill(s4); 	p5.addSkill(s1); 	p5.addSkill(s2); 	p5.addSkill(s3);
	
	TabellaImpiegati.add(p1);
	TabellaImpiegati.add(p2);
	TabellaImpiegati.add(p3);
	TabellaImpiegati.add(p4);
	TabellaImpiegati.add(p5);
	
	}
	
	public void add_Impiegato(Impiegato imp) {
		this.TabellaImpiegati.add(imp);
		for (Impiegato i: TabellaImpiegati) {
			for(Skill s: i.Abilità) {
				System.out.println(s.getNome());
			}
		}
	}
	
	public void add_Progetto(Progetto pro) {
		this.TabellaProgetti.add(pro);
		for (Progetto p: TabellaProgetti) {
			System.out.println(p.Titolo);
		}
	}

	public void add_Meeting(Meeting mee) {
		this.TabellaMeeting.add(mee);
	}
	
	public void add_Skill(Skill ski) {
		this.TabellaSkills.add(ski);
		for (Skill p: TabellaSkills) {
			System.out.println(p.Nome);
		}
	}
	
	
	public boolean ProgettoByTitolo(String titolo) {
			boolean temp= false;

			for(Progetto p: TabellaProgetti) {
				if(titolo.equals(p.Titolo)) {
					temp=true;
				}
			}
			return temp;
	}
	public boolean isAbilità(String abilità) {
		boolean temp= false;
		for(Skill s:TabellaSkills) {
			if(abilità.equals(s.Nome)) {
				temp=true;
			}
		}
		return temp;
	}
}
