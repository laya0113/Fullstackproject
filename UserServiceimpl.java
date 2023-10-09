package springbootproject.flightmanagement.ServiceImp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootproject.flightmanagement.Model.User;
import springbootproject.flightmanagement.Repository.UserRespository;
@Service
public class UserServiceimpl {
			@Autowired
			private UserRespository userRepo;
			

			public void addUser(User user) {
				
				this.userRepo.save(user);
				
			}

			public Optional<User> getUserByEmail(String email) {
				
				return this.userRepo.findByuserEmail(email);
				
			}
		}

