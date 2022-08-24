package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concrete.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
	JobTitle findByTitle(String title);
}
