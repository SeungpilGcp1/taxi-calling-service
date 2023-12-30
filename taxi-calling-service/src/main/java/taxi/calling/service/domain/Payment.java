package taxi.calling.service.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxi.calling.service.TaxiCallingServiceApplication;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    private String rideId;

    private String customerId;

    private Money amount;

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = TaxiCallingServiceApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public void receivePayment(ReceivePaymentCommand receivePaymentCommand) {
        //implement business logic here:

        PaymentReceived paymentReceived = new PaymentReceived(this);
        paymentReceived.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completePayment(CompletePaymentCommand completePaymentCommand) {
        //implement business logic here:

        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
