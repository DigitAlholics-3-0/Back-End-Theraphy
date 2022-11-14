package com.theraphy.backendtheraphy.profiles.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.University;
import com.theraphy.backendtheraphy.profiles.domain.persistence.UniversityRepository;
import com.theraphy.backendtheraphy.profiles.domain.service.UniversityService;
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
public class UniversityServiceImpl implements UniversityService {

    private static final String ENTITY = "University";

    private final UniversityRepository universityRepository;

    private final Validator validator;

    public UniversityServiceImpl(UniversityRepository universityRepository, Validator validator) {
        this.universityRepository = universityRepository;
        this.validator = validator;
    }

    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @Override
    public Page<University> getAll(Pageable pageable) {
        return universityRepository.findAll(pageable);
    }

    @Override
    public University getById(Long universityId) {
        return universityRepository.findById(universityId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, universityId));
    }

    @Override
    public University create(University university) {
        Set<ConstraintViolation<University>> violations = validator.validate(university);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        University universityWithName = universityRepository.findByName(university.getName());

        if(universityWithName!= null)
            throw new ResourceValidationException(ENTITY,
                    "A university with the same name already exists.");

        return universityRepository.save(university);
    }
}
