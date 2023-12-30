package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class StartRideCommand {

    private String rideId;
}
