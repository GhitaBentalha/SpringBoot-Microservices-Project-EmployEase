package com.hirehub.EmployEase.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hirehub.EmployEase.company.Company;
import com.hirehub.EmployEase.company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
       List<Review> reviews = reviewRepository.findByCompanyId(companyId);
       return reviews;
    }

    @Override
    public boolean addReview(Long companyId,Review review) {
        Company company = companyService.findById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Review findById(Long companyId, Long reviewId) {
      List<Review> reviews = reviewRepository.findByCompanyId(companyId);
      return reviews.stream().filter(review->review.getId()
            .equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReviewByiId(Long companyId, Long reviewId, Review review) {
       Review reviewtoUpdate = findById(companyId, reviewId);
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
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        Review reviewtoDelete = findById(companyId, reviewId);
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

}
