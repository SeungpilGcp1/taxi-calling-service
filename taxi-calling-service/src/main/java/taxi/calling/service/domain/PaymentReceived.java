package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import taxi.calling.service.domain.*;
import taxi.calling.service.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentReceived extends AbstractEvent {

    private String rideId;
    private String customerId;
    private Money amount;

    public PaymentReceived(Payment aggregate) {
        super(aggregate);
    }

    public PaymentReceived() {
        super();
    }
}
//>>> DDD / Domain Event
