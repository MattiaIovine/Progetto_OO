package Codice;
import java.util.ArrayList;

public class Impiegato {
	
	
	//ATTRIBUTI 
	private String CF;
	private String Nome;
	private String Cognome;
	private String Mail;
	private String Telefono;
	private double  Salario;
	private int 	  Valutazione = 0;
	private ArrayList<Skill> Abilità = new ArrayList<>();
	private ArrayList<Progetto> Lavori = new ArrayList<>();
	private ArrayList<Meeting> Partecipazioni = new ArrayList<>();

	
	//Controller theController;
	
	//COSTRUTTORE
	public Impiegato(String cF, String nome, String cognome, String mail, String telefono, double salario) {
		CF = cF;
		Nome = nome;
		Cognome = cognome;
		Mail = mail;
		Telefono = telefono;
		Salario = salario; 
	}
	
	public void addSkill(Skill s) {
		this.Abilità.add(s);
	}
	
	public void addSkill(ArrayList<Skill> s) {
		for(Skill abilità:s) {
			this.Abilità.add(abilità);
		}
	}
	
	public ArrayList<Skill> getSkills(){
		return this.Abilità;
	}
	
	public String toString() {
		return("CF: "+this.CF+" Nome: "+this.Nome+" Cognome: "+this.Cognome+" Salario: "+this.Salario+" Valutazione:"+this.Valutazione);
	}
	
	public String toStringMinimo() {
		return ("CF:"+this.CF+ " Nome: "+this.Nome+" Cognome: "+this.Cognome);
	}
	
	//METODI
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF; 
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(float salario) {
		Salario = salario;
	}
	public int getValutazione() {
		return Valutazione;
	}
	public void addValutazione(int valutazione) {
		Valutazione+=valutazione;
	}
	
	public boolean isambito(String ambito) {
		boolean temp=false;
		if(!ambito.equals("Qualsiasi")) {
			for(Progetto p:Lavori) {
				if(ambito.equals(p.getAmbito())) {
					temp=true;
				}
			}
		}
		else {
			temp=true;
		}
		return temp;
	}

	public void addProgetto(Progetto progetto) {
		this.Lavori.add(progetto);
	}


	
}
