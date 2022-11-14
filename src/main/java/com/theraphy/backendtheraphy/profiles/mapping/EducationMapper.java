package com.theraphy.backendtheraphy.profiles.mapping;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Education;
import com.theraphy.backendtheraphy.profiles.resource.CreateEducationResource;
import com.theraphy.backendtheraphy.profiles.resource.EducationResource;
import com.theraphy.backendtheraphy.security.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.security.resource.CreatePatientResource;
import com.theraphy.backendtheraphy.security.resource.PatientResource;
import com.theraphy.backendtheraphy.security.resource.UpdatePatientResource;
import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.util.List;

public class EducationMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public EducationResource toResource(Education model) {
        return mapper.map(model, EducationResource.class);
    }

    public Education toModel(CreateEducationResource resource) {
        return mapper.map(resource, Education.class);
    }

    public Page<EducationResource> modelListPage(List<Education> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EducationResource.class), pageable, modelList.size());
    }
}
