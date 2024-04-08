package com.hirehub.EmployEase.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review findById(Long companyId, Long reviewId);
    boolean updateReviewByiId(Long companyId, Long reviewId, Review review);
    boolean deleteReviewById(Long companyId, Long reviewId);
}
