package com.hirehub.reviews.microservice.review;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public ResponseEntity<List<Review>> getAllReview(@RequestParam Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
        HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@RequestParam Long companyId,@PathVariable Long id)
    {
        Review review = reviewService.findReviewById(companyId,id);
        if(review!=null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/average-rating/{companyId}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long companyId) {
        double averageRating = reviewService.averageRating(companyId);
        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addReview(@RequestParam Long companyId,@RequestBody Review review)
    {
        boolean isReviewAdded =   reviewService.addReview(companyId,review);
        if(isReviewAdded){
            return new ResponseEntity<>("Review added successfully!",HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("Review not added company doesn't exist!",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review, @RequestParam Long companyId)
    {
        boolean isUpdated = reviewService.updateReviewById(companyId,id,review);
        if(isUpdated)
        {
            return new ResponseEntity<>("Review updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Review not found!",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteReview(@RequestParam Long companyId ,@PathVariable Long id)
    {
        boolean isDeleted = reviewService.deleteReviewById(companyId,id);
        if(isDeleted)
        {
            return new ResponseEntity<>("Review deleted successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Review not found!",HttpStatus.NOT_FOUND);
        }
    }

}
