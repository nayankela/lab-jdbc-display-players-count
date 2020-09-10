package controller;

import java.util.Map;
import java.util.TreeMap;
import dao.SkillDAO;
import model.Skill;

public class Main {
	public static void main(String[] args) {
		SkillDAO skillDAO = new SkillDAO();
		TreeMap<Skill, Integer> skillsMap = skillDAO.skillCount();
		for(Map.Entry<Skill,Integer> entry : skillsMap.entrySet()) {
			  String key = entry.getKey().getSkillName();
			  Integer value = entry.getValue();

			  System.out.println(key + "  " + value);
			}
	}
}
