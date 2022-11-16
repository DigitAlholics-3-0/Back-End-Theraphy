package com.theraphy.backendtheraphy.treatments.mapping;

import com.theraphy.backendtheraphy.shared.mapping.EnhancedModelMapper;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import com.theraphy.backendtheraphy.treatments.resource.CreateTreatmentResource;
import com.theraphy.backendtheraphy.treatments.resource.TreatmentResource;
import com.theraphy.backendtheraphy.treatments.resource.UpdateTreatmentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TreatmentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public TreatmentResource toResource(Treatment model) {
        return mapper.map(model, TreatmentResource.class);
    }

    public Treatment toModel(CreateTreatmentResource resource) {
        return mapper.map(resource, Treatment.class);
    }

    public Treatment toModel(UpdateTreatmentResource resource) {return mapper.map(resource, Treatment.class);}

    public Page<TreatmentResource> modelListPage(List<Treatment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TreatmentResource.class), pageable, modelList.size());
    }
}