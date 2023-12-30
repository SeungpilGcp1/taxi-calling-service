package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxi.calling.service.TaxiCallingServiceApplication;
import taxi.calling.service.domain.ReviewSubmitted;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    private String rideId;

    private Rating rating;

    private Comment comment;

    @PostPersist
    public void onPostPersist() {
        ReviewSubmitted reviewSubmitted = new ReviewSubmitted(this);
        reviewSubmitted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = TaxiCallingServiceApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public void receiveReview(ReceiveReviewCommand receiveReviewCommand) {
        //implement business logic here:

        ReviewReceived reviewReceived = new ReviewReceived(this);
        reviewReceived.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
