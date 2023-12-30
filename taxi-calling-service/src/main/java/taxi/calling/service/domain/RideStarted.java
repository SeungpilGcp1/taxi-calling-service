package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RideStarted extends AbstractEvent {

    private String rideId;

    public RideStarted(Ride aggregate) {
        super(aggregate);
    }

    public RideStarted() {
        super();
    }
}
//>>> DDD / Domain Event
