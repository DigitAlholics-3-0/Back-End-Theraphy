package com.theraphy.backendtheraphy.profile.domain.persistence;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, Long> {
    Physiotherapist findByFirstName(String firstName);
}