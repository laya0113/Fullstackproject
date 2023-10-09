package springbootproject.flightmanagement.ServiceImp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootproject.flightmanagement.Model.FlightCompany;
import springbootproject.flightmanagement.Repository.FlightCompanyRepository;

import springbootproject.flightmanagement.Service.FlightCompanyService;

@Service
public class FlightCompanyServiceImpl implements FlightCompanyService {
	
       private FlightCompanyRepository companyRepository;
	
    @Autowired
	public FlightCompanyServiceImpl(FlightCompanyRepository companyRepository) {
		this.companyRepository=companyRepository;
	}

	@Override
	public FlightCompany updateDetailsUsingId(FlightCompany companyObj, int companyId) {
		Optional<FlightCompany> companyFromDb = companyRepository.findById(companyId); 
		if(companyFromDb.isPresent()) {
			FlightCompany existingCompany=companyFromDb.get();
			
			existingCompany.setCompanyName(companyObj.getCompanyName());
			existingCompany.setFounderName(companyObj.getFounderName());
			existingCompany.setYearsOfService(companyObj.getYearsOfService());
		
			companyRepository.save(existingCompany);
			
			return existingCompany;
			}
		else {
			return null;
		}
		}
	

	@Override
	public void deleteCompanyDetailsById(int companyId) {
		Optional<FlightCompany> companyObj = companyRepository.findById(companyId);  //null , or it can 5tg person rec
		if(companyObj.isPresent()) {
			companyRepository.deleteById(companyId);
		}
	}

	@Override
	public FlightCompany getDetailsById(int companyId) {
		Optional<FlightCompany> companyObj = companyRepository.findById(companyId);  //null , or it can 5tg person rec
		if(companyObj.isPresent()) {
			return companyObj.get();
		}
		else {
			return null;
		}
}	

	@Override
	public List<FlightCompany> getAllCompanyDetails() {
		return companyRepository.findAll();

	}

	@Override
	public void deleteCompanyDetails() {
		companyRepository.deleteAll();
		
	}

	@Override
	public FlightCompany createCompanyDetails(FlightCompany companyObj) {
		return companyRepository.save(companyObj);
	}
	@Override
	public List<FlightCompany> searchByCompanyName(String companyName) {
		return companyRepository.findByCompanyNameContainingIgnoreCase(companyName);
	}

}
