package springbootproject.flightmanagement.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import springbootproject.flightmanagement.Model.FlightDetails;


@Service
public interface FlightDetailsService {
	

	    FlightDetails updateDetailsUsingId(FlightDetails flightObj,int id);
		void deleteFlightDetailsById(int id);
		FlightDetails getDetailsById(int id);
		List<FlightDetails> getAllFlightDetails();
		void deleteFlightDetails();
		FlightDetails createFlightDetails(FlightDetails flightObj);
		 		
		List<FlightDetails> checkIfFlightIsDomestic(Boolean booleanObj) ;
        List<FlightDetails> searchByFlightName(String flightName);
		List<FlightDetails> searchByDepartureCityAndArrivalCity(String departureCity,String arrivalCity);
		List<FlightDetails> sortByTicketCost(String direction, String fieldName);
		List<FlightDetails> sortByFlightRating(String direction, String fieldName);
		
		
		
		

		  
		

	

}