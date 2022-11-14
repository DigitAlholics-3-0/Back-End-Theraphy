package com.theraphy.backendtheraphy.social.api.rest;

import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.domain.service.PatientService;
import com.theraphy.backendtheraphy.social.domain.service.ReviewService;
import com.theraphy.backendtheraphy.social.mapping.ReviewMapper;
import com.theraphy.backendtheraphy.social.resource.CreateReviewResource;
import com.theraphy.backendtheraphy.social.resource.ReviewResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/patients/{patientId}/reviews", produces = "application/json")
@Tag(name = "Patients", description = "Create, read, update and delete patients")
public class PatientReviewController {

    private final PatientService patientService;

    private final ReviewService reviewService;

    private final ReviewMapper mapper;

    public PatientReviewController(PatientService patientService, ReviewService reviewService, ReviewMapper mapper) {
        this.patientService = patientService;
        this.reviewService = reviewService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<ReviewResource> getAllReviewsByPatientId(@PathVariable Long patientId,
                                                       Pageable pageable) {
        return mapper.modelListPage(patientService.getById(patientId)
                .getReviews().stream().toList(), pageable);
    }

    /*@PostMapping
    public ReviewResource createReview(@PathVariable Long patientId,
                                             @RequestBody CreateReviewResource resource) {

        patientService.addReviewToPatient(patientId, resource.getPhysiotherapist(), resource.getReviewer(),
                resource.getStars(), resource.getDescription(), new Physiotherapist());
        return mapper.toResource(reviewService.
                .getByNameAndSkillId(resource.getName(), skillId));
    }*/
}