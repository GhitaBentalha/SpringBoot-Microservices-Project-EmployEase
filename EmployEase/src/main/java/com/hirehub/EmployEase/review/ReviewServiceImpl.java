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

}
