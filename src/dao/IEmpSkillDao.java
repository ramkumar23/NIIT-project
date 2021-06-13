package dao;
import java.util.List;
import model.Empskill;

public interface IEmpSkillDao {
	
	List<Empskill> getAllEmpskills();
	void addEmpskill(Empskill esk);
	Empskill getEmpskillById(int id);
	void updateEmpskill(Empskill esk);
	void deleteEmpskill(int id);

}
