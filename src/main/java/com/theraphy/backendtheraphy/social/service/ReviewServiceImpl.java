package com.theraphy.backendtheraphy.social.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import com.theraphy.backendtheraphy.social.domain.persistence.ReviewRepository;
import com.theraphy.backendtheraphy.social.domain.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String ENTITY = "Review";

    private final ReviewRepository reviewRepository;

    private final Validator validator;

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator) {
        this.reviewRepository = reviewRepository;
        this.validator = validator;
    }

    @Override
    public List<Review> getAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Page<Review> getAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, reviewId));    }

    @Override
    public Review create(Review review) {
        Set<ConstraintViolation<Review>> violations = validator.validate(review);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reviewRepository.save(review);
    }

   /* @Override
    public Review getByDataAndPatientId(String physiotherapist, String reviewer, Integer stars, String description, Physiotherapist doctor, Long patientId) {
        return reviewRepository.findByPhysiotherapist(physiotherapist, patientId)
                .orElseThrow(() -> new ResourceNotFoundException("No Criterion with this name found for Skill"));
    }
*/


    @Override
    public Review update(Long reviewId, Review request) {
        Set<ConstraintViolation<Review>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reviewRepository.findById(reviewId).map(review ->
                        reviewRepository.save(
                                review.withReviewer(request.getReviewer())
                                        .withStars(request.getStars())
                                        .withPhysiotherapist(request.getPhysiotherapist())
                                        .withDescription(request.getDescription())
                                        .withDoctor(request.getDoctor())
                                        .withPatient(request.getPatient())))
                        .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reviewId));
    }

    @Override
    public ResponseEntity<?> delete(Long reviewId) {
        return reviewRepository.findById(reviewId).map( treatment -> {
            reviewRepository.delete(treatment);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,reviewId));    }
}
