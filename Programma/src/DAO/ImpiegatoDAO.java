package DAO;
import Controller.Controller;
import Database.*;

import java.util.ArrayList;

import Codice.Impiegato;
import Codice.Skill;

public class ImpiegatoDAO {
	
	
	
//	public void add_Impiegato_To_DB (String cF, String nome, String cognome, String mail, String telefono, double salario, Database DB) {
//		Impiegato p1 = new Impiegato(cF, nome, cognome, mail, telefono, salario);
//		DB.add_Impiegato(p1);
//	}
//	
	public void add_Impiegato_To_DB(String cF, String nome, String cognome, String mail, String telefono, double salario, ArrayList<Skill> skills, Database DB) {
		Impiegato p1 = new Impiegato(cF, nome, cognome, mail, telefono, salario);
		p1.addSkill(skills);
		DB.add_Impiegato(p1);
	}
	
	public boolean isImpiegatoByCF (Database DB, String codfis) {
		return DB.ImpiegatoByCF(codfis);
	}
	
	
}
