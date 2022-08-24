package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.dto.concrete.JobAdvertisementDetailDto;
import project.hrms.entities.concrete.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	public String queryString = "select new project.hrms.dto.concrete.JobAdvertisementDetailDto(ja.id, e.companyName, jt.title,"
			+ " ja.openNumberOfPositions, ja.createdDate, ja.deadline) from JobAdvertisement "
			+ "ja inner join ja.employer e inner join ja.jobTitle jt";	
	
	@Query(queryString + " where is_active = true")
	List<JobAdvertisementDetailDto> getByIsActiveTrue();
	
	@Query(queryString +  " where is_active = true Order By ja.createdDate ASC")
	List<JobAdvertisementDetailDto> getByIsActiveTrueOrderByCreatedDate();
	
	@Query(queryString +  " where is_active = true and ja.employer.id =:employerId")
	List<JobAdvertisementDetailDto> getByIsActiveTrueAndEmployer_Id(int employerId);
}
