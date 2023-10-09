package springbootproject.flightmanagement.Repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import springbootproject.flightmanagement.Model.Feedback;

	@Repository
	public interface FeedbackRepository  extends JpaRepository<Feedback, Integer>{
		
	}
