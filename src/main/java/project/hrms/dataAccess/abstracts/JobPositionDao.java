package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concrete.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

}
