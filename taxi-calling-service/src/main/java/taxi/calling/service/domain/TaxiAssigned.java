package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TaxiAssigned extends AbstractEvent {

    private String driverId;
    private String taxiCallId;

    public TaxiAssigned(TaxiCall aggregate) {
        super(aggregate);
    }

    public TaxiAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
