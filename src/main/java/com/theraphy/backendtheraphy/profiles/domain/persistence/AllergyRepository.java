package com.theraphy.backendtheraphy.profiles.domain.persistence;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Allergy;
import com.theraphy.backendtheraphy.profiles.domain.model.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy,Long> {
   Allergy findByName(String name);

}
