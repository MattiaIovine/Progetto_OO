package DAO;
import java.util.ArrayList;

import Codice.Skill;
import Database.*;

public class SkillDAO {
	
	public ArrayList<Skill> add_Skill_To_DB(ArrayList<String> abilità, Database DB) {
	ArrayList<Skill> skill = new ArrayList<>();
	
	for(String nome:abilità) {
		if(DB.isSkill(nome)) {
			skill.add(DB.getSkill(nome));
		}
		else {
			Skill s = new Skill(nome);
			skill.add(s);
			DB.add_Skill(s);
		}
	}
	return skill;
	}
	
	public ArrayList<Skill> get_Skills_From_DB(Database DB){
		return DB.getSkills();
	}
}
