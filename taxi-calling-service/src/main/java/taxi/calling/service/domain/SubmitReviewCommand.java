package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitReviewCommand {

    private String rideId;
    private Rating rating;
    private Comment comment;
}
