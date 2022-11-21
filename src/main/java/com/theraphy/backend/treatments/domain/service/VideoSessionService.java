package com.theraphy.backend.treatments.domain.service;

import com.theraphy.backend.treatments.domain.model.entity.VideoSession;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VideoSessionService {

    List<VideoSession> getAll();

    VideoSession getById(Long videoSessionId);

    VideoSession create(VideoSession videoSession);

    ResponseEntity<?> delete(Long videoSessionId);
}
