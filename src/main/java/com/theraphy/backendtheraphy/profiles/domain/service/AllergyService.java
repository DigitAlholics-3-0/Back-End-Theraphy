package com.theraphy.backendtheraphy.profiles.domain.service;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Allergy;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllergyService {
    List<Allergy> getAll();
    Page<Allergy> getAll(Allergy pageable);
    Allergy getById(Long allergyId);
    Allergy create(Allergy allergy);
    Allergy update(Long allergyId, Allergy request);
    ResponseEntity<?> delete(Long allergyId);

}
