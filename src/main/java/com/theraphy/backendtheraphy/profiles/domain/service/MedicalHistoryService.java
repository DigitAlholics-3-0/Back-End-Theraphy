package com.theraphy.backendtheraphy.profiles.domain.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.MedicalHistory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicalHistoryService {

    List<MedicalHistory> getAll();
    Page<MedicalHistory> getAll(MedicalHistory pageable);
    MedicalHistory getById(Long medicalHistoryId);
    MedicalHistory create(MedicalHistory medicalHistory);
    MedicalHistory update(Long medicalHistoryId, MedicalHistory request);
    ResponseEntity<?> delete(Long medicalHistoryId);
}
