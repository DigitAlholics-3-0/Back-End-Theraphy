package com.theraphy.backendtheraphy.profiles.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.MedicalHistory;
import com.theraphy.backendtheraphy.profiles.domain.persistence.MedicalHistoryRepository;
import com.theraphy.backendtheraphy.profiles.domain.service.MedicalHistoryService;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    private static final String ENTITY = "Medical_History";

    private final MedicalHistoryRepository medicalHistoryRepository;

    private final Validator validator;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository, Validator validator) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.validator = validator;
    }

    @Override
    public List<MedicalHistory> getAll() {
        return medicalHistoryRepository.findAll();
    }

    @Override
    public Page<MedicalHistory> getAll(Pageable pageable) {
        return medicalHistoryRepository.findAll(pageable);
    }

    @Override
    public MedicalHistory getById(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, medicalHistoryId));
    }

    @Override
    public MedicalHistory create(MedicalHistory medicalHistory) {
        Set<ConstraintViolation<MedicalHistory>> violations = validator.validate(medicalHistory);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        MedicalHistory medicalHistoryWithPatientName= medicalHistoryRepository.findByPatientName(medicalHistory.getPatientName());

        if(medicalHistoryWithPatientName != null)
            throw new ResourceValidationException(ENTITY,
                    "A Medical History with the same Patient Name already exists.");

        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public MedicalHistory update(Long medicalHistoryId, MedicalHistory request) {
        Set<ConstraintViolation<MedicalHistory>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return medicalHistoryRepository.findById(medicalHistoryId).map(medicalHistory ->
                        medicalHistoryRepository.save(
                                medicalHistory.withPatientName(request.getPatientName())
                                        .withHeight(request.getHeight())
                                        .withWeight(request.getWeight())
                                        .withBodyMass(request.getBodyMass())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, medicalHistoryId));
    }

    @Override
    public ResponseEntity<?> delete(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId).map( medicalHistory -> {
            medicalHistoryRepository.delete(medicalHistory);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,medicalHistoryId));
    }
}
