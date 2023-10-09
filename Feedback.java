package springbootproject.flightmanagement.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Feedback  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedBackId;
	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer flightRating;
	
	@Min(value=1, message="Rating must be in range of 1-5")
	@Max(value=5, message="Rating must be in range of 1-5")
	private Integer overallRating;
	
	private String comments;

	@OneToOne
	private User user;
	
	@OneToOne
	private FlightDetails flightDetails ;

	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}

	public Integer getFlightRating() {
		return flightRating;
	}

	public void setFlightRating(Integer flightRating) {
		this.flightRating = flightRating;
	}

	public Integer getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", flightRating=" + flightRating + ", overallRating="
				+ overallRating + ", comments=" + comments + ", user=" + user + ", flightDetails=" + flightDetails
				+ "]";
	}

	
	
}
