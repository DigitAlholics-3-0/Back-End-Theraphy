package com.theraphy.backendtheraphy.treatments.domain.persistence;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.TreatmentPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentPatientRepository extends JpaRepository<TreatmentPatient,Long>  {

    TreatmentPatient findByPatientAndPatientId(Patient patient, Long patientId);
    Optional<TreatmentPatient> findByTreatmentId(Long treatmentId);
    TreatmentPatient findByTreatmentAndTreatmentTitle(Treatment treatment, String treatmentTitle);


}
