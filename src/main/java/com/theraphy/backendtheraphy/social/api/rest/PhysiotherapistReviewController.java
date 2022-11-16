package com.theraphy.backendtheraphy.social.api.rest;

import com.theraphy.backendtheraphy.profile.domain.service.PhysiotherapistService;
import com.theraphy.backendtheraphy.social.domain.service.ReviewService;
import com.theraphy.backendtheraphy.social.mapping.ReviewMapper;
import com.theraphy.backendtheraphy.social.resource.CreateReviewResource;
import com.theraphy.backendtheraphy.social.resource.ReviewResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/physiotherapists/{physiotherapistId}/reviews", produces = "application/json")
@Tag(name = "Physiotherapist Reviews", description = "Create, read, update and delete reviews")
public class PhysiotherapistReviewController {
    private final PhysiotherapistService physiotherapistService;

    private final ReviewService reviewService;

    private final ReviewMapper mapper;

    public PhysiotherapistReviewController(PhysiotherapistService physiotherapistService, ReviewService reviewService, ReviewMapper mapper) {
        this.physiotherapistService = physiotherapistService;
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReviewResource> getAllReviewsByPhysiotherapistId(@PathVariable Long physiotherapistId,
                                                                      Pageable pageable) {
        return mapper.modelListPage(physiotherapistService.getById(physiotherapistId)
                .getReviews().stream().toList(), pageable);
    }

    @PostMapping
    public ReviewResource createAppointment(@PathVariable Long physiotherapistId,
                                                 @RequestBody CreateReviewResource resource) {

        physiotherapistService.addReviewToPhysiotherapist(physiotherapistId, resource.getDescription(), resource.getStars());
        return mapper.toResource(reviewService
                .getByStarsAndPhysiotherapistId(resource.getStars(), physiotherapistId));
    }
}
