package springbootproject.flightmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
	@Service
	public class EmailService {
		


			@Autowired
			private JavaMailSender javaMailSender;
			@Async
			public void sendEmail1(String toEmail,String subject,String message)
			{
				SimpleMailMessage mailMessage=new SimpleMailMessage();
				mailMessage.setTo(toEmail);
				mailMessage.setSubject(subject);
				mailMessage.setText(message);
				mailMessage.setFrom("layasree901@gmail.com");
				((JavaMailSender) javaMailSender).send(mailMessage);
				System.out.println("mail send successfully...");
			}
	}

