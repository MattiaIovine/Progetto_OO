package DAO;
import java.util.ArrayList;

import Codice.Skill;
import Database.*;

public class SkillDAO {
	
	public ArrayList<Skill> add_Skill_To_DB(ArrayList<String> abilit�, Database DB) {
	ArrayList<Skill> skill = new ArrayList<>();
	for(String nome:abilit�) {
		Skill s = new Skill(nome);
		skill.add(s);
		if(!DB.isSkill(nome)) {
			DB.add_Skill(s);
		}
	}
	return skill;
	}
	
	public ArrayList<Skill> get_Skills_From_DB(Database DB){
		return DB.getSkills();
	}
}
