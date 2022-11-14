package com.theraphy.backendtheraphy.social.api.rest;

import com.theraphy.backendtheraphy.social.domain.service.ReviewService;
import com.theraphy.backendtheraphy.social.mapping.ReviewMapper;
import com.theraphy.backendtheraphy.social.resource.ReviewResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = "application/json")
@Tag(name = "Reviews", description = "Create, read, update and delete reviews")
public class ReviewController {
    private final ReviewService reviewService;

    private final ReviewMapper mapper;

    public ReviewController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<ReviewResource> getAllCriteria(Pageable pageable) {
        return mapper.modelListPage(reviewService.getAll(), pageable);
    }
}
