package springbootproject.flightmanagement.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import springbootproject.flightmanagement.Model.Feedback;

@Service
public interface FeedbackService {


public Feedback addFeedBack(Feedback feedBack,Integer flightId, Long userId) throws Exception;
	

	public void deleteFeedBack(Integer feedbackId) throws Exception;

	public Feedback viewFeedback(Integer flightId) throws Exception;

	public List<Feedback> viewFeedbackAll() throws Exception ;
	
}