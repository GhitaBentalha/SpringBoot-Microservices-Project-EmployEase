package com.hirehub.reviews.microservice.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hirehub.reviews.microservice.review.messaging.ReviewMessageProducer;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMessageProducer reviewMessageProducer;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMessageProducer reviewMessageProducer) {
        this.reviewRepository = reviewRepository;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
       List<Review> reviews = reviewRepository.findByCompanyId(companyId);
       return reviews;
    }

    @Override
    public boolean addReview(Long companyId,Review review) {
        if(companyId!=null)
        {
            review.setCompanyId(companyId);
            reviewMessageProducer.sendMessage(review);
            reviewRepository.save(review);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Review findReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = getAllReviews(companyId);
             return reviews.stream().filter(review->review.getId()
            .equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReviewById(Long companyId,Long reviewId, Review review) {
       Review reviewtoUpdate = findReviewById(companyId,reviewId);
       if(reviewtoUpdate!=null)
       {
        reviewtoUpdate.setTitle(review.getTitle());
        reviewtoUpdate.setDescription(review.getDescription());
        reviewtoUpdate.setRating(review.getRating());
        reviewRepository.save(review);
        return true;
       }
       else
       {
        return false;
       }
    }

    @Override
    public boolean deleteReviewById(Long companyId,Long reviewId) {
        Review reviewtoDelete = findReviewById(companyId,reviewId);
        if(reviewtoDelete!=null)
        {
         reviewRepository.delete(reviewtoDelete);
         return true;
        }
        else
        {
         return false;
        }
    }

    @Override
    public double averageRating(Long companyId) {
        List<Review> reviews = getAllReviews(companyId);
        if (reviews.isEmpty()) {
            return 0.0;
        }
    
        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }
        double averageRating = totalRating / reviews.size();
        return Math.round(averageRating * 10.0) / 10.0;
    }

}
