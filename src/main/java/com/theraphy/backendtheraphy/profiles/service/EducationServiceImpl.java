package com.theraphy.backendtheraphy.profiles.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Education;
import com.theraphy.backendtheraphy.profiles.domain.persistence.EducationRepository;
import com.theraphy.backendtheraphy.profiles.domain.service.EducationService;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.shared.exception.ResourceNotFoundException;
import com.theraphy.backendtheraphy.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EducationServiceImpl implements EducationService {

    private static final String ENTITY = "Education";

    private final EducationRepository educationRepository;

    private final Validator validator;

    public EducationServiceImpl(EducationRepository educationRepository, Validator validator) {
        this.educationRepository = educationRepository;
        this.validator = validator;
    }


    @Override
    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    @Override
    public Page<Education> getAll(Pageable pageable) {
        return educationRepository.findAll(pageable);
    }

    @Override
    public Education getById(Long educationId) {
        return educationRepository.findById(educationId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, educationId));
    }

    @Override
    public Education create(Education education) {
        Set<ConstraintViolation<Education>> violations = validator.validate(education);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Education educationWithSpecialization = educationRepository.findBySpecialization(education.getSpecialization());

        if(educationWithSpecialization != null)
            throw new ResourceValidationException(ENTITY,
                    "A education with the same specialization already exists.");

        return educationRepository.save(education);
    }
}
