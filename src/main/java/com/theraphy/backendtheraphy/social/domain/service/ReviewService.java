package com.theraphy.backendtheraphy.social.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Page<Review> getAll(Pageable pageable);
    Review getById(Long reviewId);
    Review create(Review review);
   /* Review getByDataAndPatientId(String physiotherapist,
                               String reviewer,
                               Integer stars,
                               String description,
                               Physiotherapist doctor, Long patientId);*/

    Review update(Long reviewId, Review request);
    ResponseEntity<?> delete(Long reviewId);
}
