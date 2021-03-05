package Codice;
import java.util.ArrayList;
import java.util.Collections;

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
//	public ArrayList<Meeting> Partecipazioni;

	
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
		return(this.CF+" "+this.Nome+" "+this.Cognome+" "+this.Salario);
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
	public void setValutazione(int valutazione) {
		Valutazione = valutazione;
	}
	
	
	
}
