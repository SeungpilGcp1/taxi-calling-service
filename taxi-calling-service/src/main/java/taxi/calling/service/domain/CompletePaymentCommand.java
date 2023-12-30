package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompletePaymentCommand {

    private String rideId;
}
