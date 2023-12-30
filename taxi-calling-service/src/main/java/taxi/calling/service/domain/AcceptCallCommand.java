package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AcceptCallCommand {

    private String driverId;
    private String taxiCallId;
}
