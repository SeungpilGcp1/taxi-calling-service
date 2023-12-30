package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReceivePaymentCommand {

    private String rideId;
    private String customerId;
    private Money amount;
}
