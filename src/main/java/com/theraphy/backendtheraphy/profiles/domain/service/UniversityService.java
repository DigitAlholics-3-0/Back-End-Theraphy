package com.theraphy.backendtheraphy.profiles.domain.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Education;
import com.theraphy.backendtheraphy.profiles.domain.model.entity.University;
import com.theraphy.backendtheraphy.profiles.mapping.UniversityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityService {

    List<University> getAll();

    Page<University> getAll(Pageable pageable);

    University getById(Long universityId);

    University create(University university);
}
