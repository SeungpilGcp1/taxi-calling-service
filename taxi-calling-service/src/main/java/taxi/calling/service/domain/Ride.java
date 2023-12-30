package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxi.calling.service.TaxiCallingServiceApplication;

@Entity
@Table(name = "Ride_table")
@Data
//<<< DDD / Aggregate Root
public class Ride {

    @Id
    private String rideId;

    private String driverId;

    private String customerId;

    private Address startLocation;

    private Address endLocation;

    @PrePersist
    public void onPrePersist() {}

    public static RideRepository repository() {
        RideRepository rideRepository = TaxiCallingServiceApplication.applicationContext.getBean(
            RideRepository.class
        );
        return rideRepository;
    }

    //<<< Clean Arch / Port Method
    public void startRide(StartRideCommand startRideCommand) {
        //implement business logic here:

        RideStarted rideStarted = new RideStarted(this);
        rideStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void pickUpCustomer(PickUpCustomerCommand pickUpCustomerCommand) {
        //implement business logic here:

        CustomerPickedUp customerPickedUp = new CustomerPickedUp(this);
        customerPickedUp.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void dropOffCustomer(DropOffCustomerCommand dropOffCustomerCommand) {
        //implement business logic here:

        CustomerDroppedOff customerDroppedOff = new CustomerDroppedOff(this);
        customerDroppedOff.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
