package com.hirehub.company.microservice.company.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.hirehub.company.microservice.company.CompanyService;
import com.hirehub.company.microservice.company.dto.ReviewMessage;

@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage)
    {
        companyService.updateCompanyRating(reviewMessage);

    }

}
