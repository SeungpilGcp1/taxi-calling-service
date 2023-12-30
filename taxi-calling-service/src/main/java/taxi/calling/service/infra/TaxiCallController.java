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
// @RequestMapping(value="/taxiCalls")
@Transactional
public class TaxiCallController {

    @Autowired
    TaxiCallRepository taxiCallRepository;

    @RequestMapping(
        value = "taxiCalls/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public TaxiCall acceptCall(
        @PathVariable(value = "id") String id,
        @RequestBody AcceptCallCommand acceptCallCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxiCall/acceptCall  called #####");
        Optional<TaxiCall> optionalTaxiCall = taxiCallRepository.findById(id);

        optionalTaxiCall.orElseThrow(() -> new Exception("No Entity Found"));
        TaxiCall taxiCall = optionalTaxiCall.get();
        taxiCall.acceptCall(acceptCallCommand);

        taxiCallRepository.save(taxiCall);
        return taxiCall;
    }
}
//>>> Clean Arch / Inbound Adaptor
