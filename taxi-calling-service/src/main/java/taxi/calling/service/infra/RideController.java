package taxi.calling.service.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taxi.calling.service.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/rides")
@Transactional
public class RideController {

    @Autowired
    RideRepository rideRepository;

    @RequestMapping(
        value = "rides/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Ride startRide(
        @PathVariable(value = "id") String id,
        @RequestBody StartRideCommand startRideCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /ride/startRide  called #####");
        Optional<Ride> optionalRide = rideRepository.findById(id);

        optionalRide.orElseThrow(() -> new Exception("No Entity Found"));
        Ride ride = optionalRide.get();
        ride.startRide(startRideCommand);

        rideRepository.save(ride);
        return ride;
    }

    @RequestMapping(
        value = "rides/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Ride pickUpCustomer(
        @PathVariable(value = "id") String id,
        @RequestBody PickUpCustomerCommand pickUpCustomerCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /ride/pickUpCustomer  called #####");
        Optional<Ride> optionalRide = rideRepository.findById(id);

        optionalRide.orElseThrow(() -> new Exception("No Entity Found"));
        Ride ride = optionalRide.get();
        ride.pickUpCustomer(pickUpCustomerCommand);

        rideRepository.save(ride);
        return ride;
    }

    @RequestMapping(
        value = "rides/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Ride dropOffCustomer(
        @PathVariable(value = "id") String id,
        @RequestBody DropOffCustomerCommand dropOffCustomerCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /ride/dropOffCustomer  called #####");
        Optional<Ride> optionalRide = rideRepository.findById(id);

        optionalRide.orElseThrow(() -> new Exception("No Entity Found"));
        Ride ride = optionalRide.get();
        ride.dropOffCustomer(dropOffCustomerCommand);

        rideRepository.save(ride);
        return ride;
    }
}
//>>> Clean Arch / Inbound Adaptor
