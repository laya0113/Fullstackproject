package springbootproject.flightmanagement.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootproject.flightmanagement.Model.FlightCompany;
import springbootproject.flightmanagement.Service.FlightCompanyService;

@CrossOrigin
@RestController
@RequestMapping("/FlightReservation.com")
public class FlightCompanyController {
	
	@Autowired
	private FlightCompanyService  companyService;
	
	public FlightCompanyController(FlightCompanyService companyService ) {
		this.companyService=companyService;
	}

	@PostMapping("/toCreateCompanyDetails")
	public FlightCompany createaCompany(@RequestBody FlightCompany companyObj ){
		return companyService.createCompanyDetails(companyObj);
	}
   
	@PutMapping("/updateByCompanyId/{companyId}")
	public ResponseEntity<FlightCompany> updateCompanyById(@PathVariable ("companyId")int companyId ,@RequestBody FlightCompany companyObj){
	try{
		return new ResponseEntity<FlightCompany>(companyService.updateDetailsUsingId(companyObj,companyId) , HttpStatus.OK);
	}catch(Exception exc) {
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	}

	@GetMapping("/toReadCompanyDetails")
	public List<FlightCompany> fetchAllCompanyDetails(){
		return companyService.getAllCompanyDetails();
	}
	@GetMapping("/readByCompanyId/{companyId}")
	public ResponseEntity<FlightCompany> fetchCompanyById(@PathVariable("comapanyId") int companyId){
		try{
			
			return new ResponseEntity<FlightCompany> (companyService.getDetailsById(companyId),HttpStatus.OK);
		}catch(Exception exc) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
		}
	@DeleteMapping("/deleteByCompanyId/{companyId}")
	public void deleteFlightDetailsByCompanyId(@PathVariable int companyId) {
		companyService.deleteCompanyDetailsById(companyId);
	}
	
	@DeleteMapping("/deleteCompanyDetails")
	public void deleteCompanyDetails() {
		companyService.deleteCompanyDetails();
	}
	
}