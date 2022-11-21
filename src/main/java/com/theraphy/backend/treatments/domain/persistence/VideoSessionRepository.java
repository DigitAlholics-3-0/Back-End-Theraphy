package com.theraphy.backend.treatments.domain.persistence;

import com.theraphy.backend.treatments.domain.model.entity.VideoSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoSessionRepository extends JpaRepository<VideoSession, Long> {

    VideoSession findByLink(String link);

}
