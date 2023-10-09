package springbootproject.flightmanagement.Controller;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootproject.flightmanagement.Model.Feedback;
import springbootproject.flightmanagement.Service.FeedbackService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/feedback")
public class FeedbackController  {


	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/add/{flightId}/{userId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
												@PathVariable("flightId") int flightId,@PathVariable("userId")Long userId) throws Exception{
		
		Feedback feedback2 = feedbackService.addFeedBack(feedback, flightId, userId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws Exception {
		
		Feedback feedback2 = feedbackService.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/feedback/all")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws Exception  {
		
		List<Feedback> feedback2 =  feedbackService.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("feedback/delete/{id}")
	public void deleteFeedback(@PathVariable("id") Integer feedbackId) throws Exception{
		
		 feedbackService.deleteFeedBack(feedbackId);
		
		
		
	}
}

