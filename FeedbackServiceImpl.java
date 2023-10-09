package springbootproject.flightmanagement.ServiceImp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootproject.flightmanagement.Model.Feedback;
import springbootproject.flightmanagement.Model.FlightDetails;
import springbootproject.flightmanagement.Model.User;
import springbootproject.flightmanagement.Repository.FeedbackRepository;
import springbootproject.flightmanagement.Repository.FlightDetailsRepository;
import springbootproject.flightmanagement.Repository.UserRespository;
import springbootproject.flightmanagement.Service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired	
	private FeedbackRepository feedBackRepository;
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private UserRespository flightUserRepository;

	//good flight/3/1
	@Override
	public Feedback addFeedBack(Feedback feedBack, Integer flightId, Long userId) throws Exception {
		
			
			Optional<FlightDetails> flightObj = flightDetailsRepository.findById(flightId);
			if (flightObj.isEmpty()) {
				throw new Exception("Flight is not present with Id: "+flightId);
			}
			Optional<User> user = flightUserRepository.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
			if (user.isEmpty()) {
				throw new Exception("User is not present with Id: "+ userId);
			}
			feedBack.setFlightDetails(flightObj.get());
			feedBack.setUser(user.get());
			Feedback savedFeedback = feedBackRepository.save(feedBack);

			return savedFeedback;
			}


	@Override
	public void deleteFeedBack(Integer feedbackId) {
		feedBackRepository.deleteById(feedbackId);
		
	}

	@Override
	public Feedback viewFeedback(Integer id) throws Exception {
		Optional<Feedback> fedOptional = feedBackRepository.findById(id);
		if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedback found!");
	
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws Exception {
		Optional<List<Feedback>> fedOptional = Optional.of(feedBackRepository.findAll());
			if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedbacks found!");
	
	}

}

