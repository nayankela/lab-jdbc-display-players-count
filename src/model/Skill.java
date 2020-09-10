package model;

public class Skill implements Comparable<Skill> {
	private Long skillld;
	private String skillName;

	public Skill(Long skillld, String skillName) {
		super();
		this.skillld = skillld;
		this.skillName = skillName;
	}

	public Long getSkillld() {
		return skillld;
	}

	public void setSkillld(Long skillld) {
		this.skillld = skillld;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public int compareTo(Skill o) {

		return this.skillName.compareTo(o.skillName);
	}

	@Override
	public String toString() {
		return "Skill [skillld=" + skillld + ", skillName=" + skillName + "]";
	}

	
}