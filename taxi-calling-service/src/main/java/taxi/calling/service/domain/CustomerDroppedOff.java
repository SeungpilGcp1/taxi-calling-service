package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CustomerDroppedOff extends AbstractEvent {

    private String rideId;

    public CustomerDroppedOff(Ride aggregate) {
        super(aggregate);
    }

    public CustomerDroppedOff() {
        super();
    }
}
//>>> DDD / Domain Event
