package com.theraphy.backendtheraphy.treatments.domain.persistence;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.TreatmentByPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TreatmentByPatientRepository extends JpaRepository<TreatmentByPatient,Long> {
    TreatmentByPatient findByPatientId(Long patientId);
}