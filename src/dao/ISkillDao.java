package dao;

import java.util.*;
import model.Empskill;
import model.Skill;
public interface ISkillDao {
	List<Skill> getAllSkills();
	void addSkill(Skill skill);
	Skill getSkillById(int id);
	void updateSkill(Skill skill);
	void activateSkill(Skill skill);
	void deactivateSkill(Skill skill);
	void deleteSkill(int id);

}
