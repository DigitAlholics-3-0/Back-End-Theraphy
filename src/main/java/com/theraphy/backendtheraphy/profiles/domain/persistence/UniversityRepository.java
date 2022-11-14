package com.theraphy.backendtheraphy.profiles.domain.persistence;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

    University findByName(String name);
}
