package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concrete.City;

public interface CityService {

	DataResult<List<City>> getAll();
	DataResult<City> getById(int cityId);
}
