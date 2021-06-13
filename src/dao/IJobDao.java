package dao;

import java.util.List;
import model.Job;

public interface IJobDao {
	List<Job> getAllJobs();
	void addJob(Job j);
	Job getJobById(int id);
	void updateJob(Job j);
	void deactivateJob(Job id);
	void deleteJob(int id);
	void activateJob(Job id);
	

}
