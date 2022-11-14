package com.theraphy.backendtheraphy.profiles.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Allergy;
import com.theraphy.backendtheraphy.profiles.domain.model.entity.MedicalHistory;
import com.theraphy.backendtheraphy.profiles.domain.persistence.AllergyRepository;
import com.theraphy.backendtheraphy.profiles.domain.service.AllergyService;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


public class AllergyServiceImpl implements AllergyService {

    private static final String ENTITY = "Allergy";

    private final AllergyRepository allergyRepository;

    private final Validator validator;

    public AllergyServiceImpl(AllergyRepository allergyRepository, Validator validator) {
        this.allergyRepository = allergyRepository;
        this.validator = validator;
    }

    @Override
    public List<Allergy> getAll() {
        return allergyRepository.findAll();
    }

    @Override
    public Page<Allergy> getAll(Pageable pageable) {
        return allergyRepository.findAll(pageable);
    }

    @Override
    public Allergy getById(Long allergyId) {
        return allergyRepository.findById(allergyId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, allergyId));
    }

    @Override
    public Allergy create(Allergy allergy) {
        Set<ConstraintViolation<Allergy>> violations = validator.validate(allergy);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return allergyRepository.save(allergy);
    }

    @Override
    public Allergy update(Long allergyId, Allergy request) {
        Set<ConstraintViolation<Allergy>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return allergyRepository.findById(allergyId).map(allergy ->
                        allergyRepository.save(
                                allergy.withName(request.getName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, allergyId));
    }

    @Override
    public ResponseEntity<?> delete(Long allergyId) {
        return allergyRepository.findById(allergyId).map( allergy -> {
            allergyRepository.delete(allergy);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,allergyId));
    }
}
