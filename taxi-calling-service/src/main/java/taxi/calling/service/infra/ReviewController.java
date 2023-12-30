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
// @RequestMapping(value="/reviews")
@Transactional
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(
        value = "reviews/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Review receiveReview(
        @PathVariable(value = "id") String id,
        @RequestBody ReceiveReviewCommand receiveReviewCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /review/receiveReview  called #####");
        Optional<Review> optionalReview = reviewRepository.findById(id);

        optionalReview.orElseThrow(() -> new Exception("No Entity Found"));
        Review review = optionalReview.get();
        review.receiveReview(receiveReviewCommand);

        reviewRepository.save(review);
        return review;
    }
}
//>>> Clean Arch / Inbound Adaptor
