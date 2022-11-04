package com.theraphy.backendtheraphy.treatments.domain.service;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TreatmentService {
    List<Treatment> getAll();
    Page<Treatment> getAll(Pageable pageable);
    Treatment getById(Long treatmentId);
    Treatment create(Treatment treatment);
    Treatment update(Long treatmentId, Treatment request);
    ResponseEntity<?> delete(Long treatmentId);
}