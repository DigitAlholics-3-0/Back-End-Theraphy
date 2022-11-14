package com.theraphy.backendtheraphy.security.domain.service;

import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.domain.model.entity.Physiotherapist;
import com.theraphy.backendtheraphy.security.domain.model.entity.User;
import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Page<Patient> getAll(Pageable pageable);
    Patient getById(Long patientId);
    Patient create(Patient patient);
    Patient update(Long patientId, Patient request);
    ResponseEntity<?> delete(Long patientId);

    //realtions
    Patient addReviewToPatient(Long reviewId,
                              String physiotherapist,
                              String reviewer,
                              Integer stars,
                              String description,
                              Physiotherapist doctor);
}