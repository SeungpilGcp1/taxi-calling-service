package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxi.calling.service.DriverManagementServiceApplication;

@Entity
@Table(name = "Driver_table")
@Data
//<<< DDD / Aggregate Root
public class Driver {

    @Id
    private String driverId;

    private String name;

    private String phone;

    private Address location;

    private String status;

    private statusType statusType;

    public static DriverRepository repository() {
        DriverRepository driverRepository = DriverManagementServiceApplication.applicationContext.getBean(
            DriverRepository.class
        );
        return driverRepository;
    }
}
//>>> DDD / Aggregate Root
