package com.theraphy.backend.treatments.mapping;


import com.theraphy.backend.shared.mapping.EnhancedModelMapper;
import com.theraphy.backend.treatments.domain.model.entity.VideoSession;
import com.theraphy.backend.treatments.resource.CreateVideoSessionResource;
import com.theraphy.backend.treatments.resource.UpdateVideoSessionResource;
import com.theraphy.backend.treatments.resource.VideoSessionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class VideoSessionsMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public VideoSessionResource toResource(VideoSession model) {
        return mapper.map(model, VideoSessionResource.class);
    }

    public VideoSession toModel(CreateVideoSessionResource resource) {
        return mapper.map(resource, VideoSession.class);
    }

    public VideoSession toModel(UpdateVideoSessionResource resource) {return mapper.map(resource, VideoSession.class);}

    public Page<VideoSessionResource> modelListPage(List<VideoSession> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, VideoSessionResource.class), pageable, modelList.size());
    }
}
