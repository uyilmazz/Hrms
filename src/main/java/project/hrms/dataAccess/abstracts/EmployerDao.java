package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concrete.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{

	Employer findByEmail(String email);
}
