package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PickUpCustomerCommand {

    private String rideId;
    private String customerId;
}
