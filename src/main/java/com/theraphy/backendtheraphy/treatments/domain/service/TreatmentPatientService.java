package com.theraphy.backendtheraphy.treatments.domain.service;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.TreatmentPatient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TreatmentPatientService {
    List<TreatmentPatient> getAll();
    Page<TreatmentPatient> getAll(Pageable pageable);
    TreatmentPatient getById(Long treatmentPatientId);

    TreatmentPatient create(TreatmentPatient treatmentPatient);
    TreatmentPatient update(Long treatmentPatientId, TreatmentPatient request);
    ResponseEntity<?> delete(Long treatmentPatientId);

    TreatmentPatient getByTreatmentId(Long treatmentId);

}
