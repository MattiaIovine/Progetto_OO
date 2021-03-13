package Database;
import java.util.ArrayList;
import Codice.*;
import DAO.*;

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
	
	p1.setValutazione(21);
	p2.setValutazione(120);
	p3.setValutazione(2);
	p4.setValutazione(42);
	p5.setValutazione(60);
	
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
	
	TabellaSkills.add(s1);
	TabellaSkills.add(s2);
	TabellaSkills.add(s3);
	TabellaSkills.add(s4);
	}
	
	public void add_Impiegato(Impiegato imp) {
		this.TabellaImpiegati.add(imp);
		for(Impiegato i:TabellaImpiegati) {
			System.out.println("Ecco le skill dell'impiegato "+i.getNome()+" "+i.getCognome());
			for(Skill s:i.getSkills()) {
				System.out.println(s.getNome());
			}
		}
	}
	
	public void add_Progetto(Progetto pro) {
		this.TabellaProgetti.add(pro);
		for(Progetto p:TabellaProgetti){
			System.out.println("Titolo:"+p.getTitolo()+" Ambito:"+p.getAmbito()+" Tipologia:"+p.getTipologia());
		}
	}

	public void add_Meeting(Meeting mee) {
		this.TabellaMeeting.add(mee);
	}
	
	public void add_Skill(Skill ski) {
		this.TabellaSkills.add(ski);
		for(Skill s:TabellaSkills) {
			System.out.println(s.getNome());
		}
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
		for(Impiegato i:TabellaImpiegati) {
			if(scelti.contains(i)) {
				i.addProgetto(TabellaProgetti.get(TabellaProgetti.size()-1));
			}	
		}
	}
	
	
}
