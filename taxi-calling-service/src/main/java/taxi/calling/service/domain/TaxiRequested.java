package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TaxiRequested extends AbstractEvent {

    private String customerId;
    private Address currentLocation;
    private Address destination;

    public TaxiRequested(TaxiCall aggregate) {
        super(aggregate);
    }

    public TaxiRequested() {
        super();
    }
}
//>>> DDD / Domain Event
