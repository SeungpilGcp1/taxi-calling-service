package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxi.calling.service.TaxiCallingServiceApplication;
import taxi.calling.service.domain.TaxiRequested;

@Entity
@Table(name = "TaxiCall_table")
@Data
//<<< DDD / Aggregate Root
public class TaxiCall {

    @Id
    private String customerId;

    private Address currentLocation;

    private Address destination;

    private String assignedDriverId;

    @PostPersist
    public void onPostPersist() {
        TaxiRequested taxiRequested = new TaxiRequested(this);
        taxiRequested.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static TaxiCallRepository repository() {
        TaxiCallRepository taxiCallRepository = TaxiCallingServiceApplication.applicationContext.getBean(
            TaxiCallRepository.class
        );
        return taxiCallRepository;
    }

    //<<< Clean Arch / Port Method
    public void acceptCall(AcceptCallCommand acceptCallCommand) {
        //implement business logic here:

        TaxiAssigned taxiAssigned = new TaxiAssigned(this);
        taxiAssigned.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
