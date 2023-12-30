package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CustomerPickedUp extends AbstractEvent {

    private String rideId;
    private String customerId;

    public CustomerPickedUp(Ride aggregate) {
        super(aggregate);
    }

    public CustomerPickedUp() {
        super();
    }
}
//>>> DDD / Domain Event
