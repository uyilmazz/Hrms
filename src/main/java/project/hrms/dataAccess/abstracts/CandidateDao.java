package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concrete.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{
	Candidate findByEmail(String email);
	Candidate findByTcNo(String tcNo);
}
