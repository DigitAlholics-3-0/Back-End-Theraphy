package com.theraphy.backendtheraphy.profiles.domain.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Education;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EducationService {

    List<Education> getAll();
    Page<Education> getAll(Pageable pageable);
    Education getById(Long educationId);
    Education create(Education education);
}
