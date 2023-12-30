package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CallTaxiCommand {

    private String customerId;
    private Address currentLocation;
    private Address destination;
}
