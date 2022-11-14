package com.theraphy.backendtheraphy.social.domain.persistence;


import com.theraphy.backendtheraphy.social.domain.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /*List<Review> findByPhysiotherapistId(Long physiotherapistId);
    Page<Review> findByPhysiotherapistId(Long physiotherapistId, Pageable pageable);
    Optional<Review> findByIdAndPhysiotherapistId(Long id, Long physiotherapistId);

    Optional<Review> findByPatientAndPhysiotherapistId(String patient, Long physiotherapistId);*/

    Review findByPhysiotherapist(String physiotherapist);
}
