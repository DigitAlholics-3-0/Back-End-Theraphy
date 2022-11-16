package com.theraphy.backendtheraphy.treatments.domain.persistence;

import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {
    Treatment findByTitle(String title);
    Optional<Treatment> findByTitleAndPhysiotherapistId(String title, Long physiotherapistId);

}