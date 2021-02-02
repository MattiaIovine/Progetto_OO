package Codice;
import java.util.ArrayList;

public class Impiegato {
	
	
	//ATTRIBUTI 
	public String CF;
	public String Nome;
	public String Cognome;
	public String Mail;
	public String    Telefono;
	public float  Salario;
	public int 	  Valutazione = 0;
	
	public ArrayList<Progetto> Lavori;
	public ArrayList<Meeting> Partecipazioni;
	public ArrayList<Skill> Abilità;
	
	//Controller theController;
	
	//COSTRUTTORE
	public Impiegato(String cF, String nome, String cognome, String mail, String telefono, float salario) {
		super();
		CF = cF;
		Nome = nome;
		Cognome = cognome;
		Mail = mail;
		Telefono = telefono;
		Salario = salario; 
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
	
	public float getSalario() {
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
