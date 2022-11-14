package com.theraphy.backendtheraphy.profiles.mapping;

import com.theraphy.backendtheraphy.profiles.domain.model.entity.Education;
import com.theraphy.backendtheraphy.profiles.domain.model.entity.University;
import com.theraphy.backendtheraphy.profiles.resource.CreateUniversityResource;
import com.theraphy.backendtheraphy.profiles.resource.UniversityResource;
import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UniversityMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public UniversityResource toResource(University model) {
        return mapper.map(model, UniversityResource.class);
    }

    public University toModel(CreateUniversityResource resource) {
        return mapper.map(resource, University.class);
    }

    public Page<UniversityResource> modelListPage(List<University> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UniversityResource.class), pageable, modelList.size());
    }
}
