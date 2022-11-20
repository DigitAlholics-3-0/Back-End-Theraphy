package com.theraphy.backendtheraphy.profile.domain.persistence;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.profile.domain.model.entity.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByFirstName(String firstName);
    Optional<Patient> findByUserId(Long userId);
}