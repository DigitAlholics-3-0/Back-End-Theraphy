package com.theraphy.backendtheraphy.profile.domain.persistence;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByFirstName(String firstName);
}