package Database;
import java.util.ArrayList;
import Codice.*;

public class Database {
	//ATTRIBUTI
	ArrayList<Impiegato> TabellaImpiegati = new ArrayList<>();
	ArrayList<Progetto> TabellaProgetti = new ArrayList<>();
	ArrayList<Meeting> TabellaMeeting = new ArrayList<>();
	ArrayList<Skill> TabellaSkills = new ArrayList<>();
	
	//METODI
	public void Inizializzazione() {
	Impiegato p1 = new Impiegato("mytg5643", "Mario", "Rossi", "mario.rossi@libero.it","0207654654",3500);
	Impiegato p2 = new Impiegato("uytf6443", "Mattia", "Iovine", "matt.iovine@studenti.unina.it","0810886549",1200);
	Impiegato p3 = new Impiegato("4edxtc43", "Felice", "Esposito", "felice.esposito9@studenti.unina.it","0813246584",1500);
	Impiegato p4 = new Impiegato("nbggt643", "Gabriele", "Belardo", "ga.belardo@studenti.unina.it","0207658874",2000);
	Impiegato p5 = new Impiegato("njhg5643", "Anna", "Verdi", "anna.verdi@libero.it","020765876",2300);
	
	ArrayList<Impiegato> temp = new ArrayList<>();
	
	p1.addValutazione(21);
	p2.addValutazione(120);
	p3.addValutazione(2);
	p4.addValutazione(42);
	p5.addValutazione(60);
	
	Progetto pro1= new Progetto("i cavalli corrono fortissimo","Economia","Ricerca Sperimentale");
	
	
	Skill s1= new Skill("skill1");
	Skill s2= new Skill("skill2");
	Skill s3= new Skill("skill3");
	Skill s4= new Skill("skill4");
	
	p1.addSkill(s1);
	p2.addSkill(s4);	p2.addSkill(s3);
	p3.addSkill(s2);
	p4.addSkill(s1);	p4.addSkill(s3);
	p5.addSkill(s4);  	p5.addSkill(s2); 	p5.addSkill(s3);
	
	TabellaImpiegati.add(p1);
	TabellaImpiegati.add(p2);
	TabellaImpiegati.add(p3);
	TabellaImpiegati.add(p4);
	TabellaImpiegati.add(p5);
	temp.add(p1);
	temp.add(p2);
	temp.add(p3);
	temp.add(p4);
	pro1.setComponenti(temp);
	TabellaProgetti.add(pro1);
	
	
	TabellaSkills.add(s1);
	TabellaSkills.add(s2);
	TabellaSkills.add(s3);
	TabellaSkills.add(s4);
	}
	
	public void add_Impiegato(Impiegato imp) {
		this.TabellaImpiegati.add(imp);
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
	
	public boolean ProgettoByTitolo(String titolo) {
			boolean temp= false;
			for(Progetto p: TabellaProgetti) if(titolo.equals(p.getTitolo())) temp=true;
			return temp;
	}
	
	public boolean isSkill(String abilità) {
		boolean temp= false;
		for(Skill s:TabellaSkills) if(abilità.equals(s.getNome())) temp=true;
		return temp;
	}
	
	public boolean ImpiegatoByCF(String codfis) {
		boolean temp=false;
		for(Impiegato i: TabellaImpiegati) if (codfis.equals(i.getCF())) temp=true;
		return temp;
	}
	
	public ArrayList<Skill> getSkills(){
		return this.TabellaSkills;
	}
	
	public ArrayList<Progetto> get_Progetti_Attivi() {
		ArrayList<Progetto> attivi = new ArrayList<>();
		for(Progetto p:TabellaProgetti) if(p.isAttivo()) attivi.add(p);
		return attivi;
	}
	
	public ArrayList<Progetto> get_Progetti_Terminati() {
		ArrayList<Progetto> terminati = new ArrayList<>();
		for(Progetto p:TabellaProgetti) if(!p.isAttivo()) terminati.add(p);
		return terminati;
	}

	public void RimuoviUltimoProgetto() {
		this.TabellaProgetti.remove(TabellaProgetti.size()-1);
	}

	public ArrayList<Impiegato> ImpiegatiByFiltri(Integer valutazione, Double salario, String ambito, ArrayList<Skill> skillSelezionate) {
		ArrayList<Impiegato> ImpiegatiFiltrati = new ArrayList<>();
		for(Impiegato i:TabellaImpiegati) {
			ArrayList<Skill> SkilldiImpiegato= i.getSkills();
			boolean skilltrovate = true;
			for(Skill s:skillSelezionate) {
				if(!SkilldiImpiegato.contains(s)) {
					skilltrovate=false;
				}
			}
			if(i.getSalario()>=salario && i.getValutazione()>=valutazione && i.isambito(ambito) && skilltrovate) {
				ImpiegatiFiltrati.add(i);
			}
		}
		return ImpiegatiFiltrati;
	}

	public void Add_Impiegati_to_Progetto(ArrayList<Impiegato> scelti) {
		TabellaProgetti.get(TabellaProgetti.size()-1).setComponenti(scelti);
		for(Impiegato i:scelti) {
			i.addProgetto(TabellaProgetti.get(TabellaProgetti.size()-1));
		}
	}

	public void Termina_Progetto(Progetto progetto, int valutazione) {
		TabellaProgetti.get(TabellaProgetti.indexOf(progetto)).setAttivo(false);
		for(Impiegato i:progetto.getComponenti()) {
			i.addValutazione(valutazione);
		}
	}

	public ArrayList<Meeting> get_Meetings() {
		ArrayList<Meeting> meetings = new ArrayList<>();
		for(Meeting m: TabellaMeeting) {
			if(!m.isTenuto()) {
				meetings.add(m);
			}
		}
		return meetings;
	}

	public void Termina_Meeting(Meeting m) {
		m.setTenuto(true);
		for(Impiegato i:m.getPartecipanti()) {
			i.addValutazione(1);
		}
	}


	
	
}
