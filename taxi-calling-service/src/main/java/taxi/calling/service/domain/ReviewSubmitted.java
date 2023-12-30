package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewSubmitted extends AbstractEvent {

    private String rideId;
    private Rating rating;
    private Comment comment;

    public ReviewSubmitted(Review aggregate) {
        super(aggregate);
    }

    public ReviewSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
