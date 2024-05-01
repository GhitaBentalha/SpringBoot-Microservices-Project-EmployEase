package com.hirehub.job.microservice.job.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hirehub.job.microservice.job.external.Review;

@FeignClient(name= "REVIEW-SERVICE",url="${review-service.url}")
public interface ReviewClient {

    @GetMapping("/api/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long companyId);

    @GetMapping("/api/reviews/average-rating")
    Double getAverageRating(@RequestParam("companyId") Long companyId);
}
