package springbootproject.flightmanagement.Controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import springbootproject.flightmanagement.Service.EmailService;

	@RestController
	public class EmailController {

			@Autowired
			private springbootproject.flightmanagement.Service.EmailService emailService;
			
			@RequestMapping("/emailsent")
			public ResponseEntity<String> checkEmail(){
				
			emailService.sendEmail1("layasree901@gmail.com", "API CREATION", "CHECKING EMAIL");
			return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
			
			}
			
		}

