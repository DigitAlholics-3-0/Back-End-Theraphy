package com.theraphy.backendtheraphy.profiles.domain.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.MedicalHistory;
import com.theraphy.backendtheraphy.profiles.domain.model.entity.PathologicalHistory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PathologicalHistoryService {
    List<PathologicalHistory> getAll();
    Page<PathologicalHistory> getAll(PathologicalHistory pageable);
    PathologicalHistory getById(Long pathologicalHistoryId);
    PathologicalHistory create(PathologicalHistory pathologicalHistory);
    PathologicalHistory update(Long pathologicalHistoryId, PathologicalHistory request);
    ResponseEntity<?> delete(Long pathologicalHistoryId);

}
