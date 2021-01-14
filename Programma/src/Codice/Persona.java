package Codice;

import java.util.ArrayList;

public class Persona {
	
	//ATTRIBUTI 
	public String CF;
	public String Nome;
	public String Cognome;
	public String Mail;
	public int    Telefono;
	public float  Salario;
	public int 	  Valutazione;
	
	public ArrayList<Progetto> Lavori;
	public ArrayList<Meeting> Partecipazioni;
	public ArrayList<Skill> Abilità;
	
	
	
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
	
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
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
