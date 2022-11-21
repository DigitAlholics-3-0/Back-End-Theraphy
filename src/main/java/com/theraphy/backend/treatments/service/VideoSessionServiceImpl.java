package com.theraphy.backend.treatments.service;

import com.theraphy.backend.shared.exception.ResourceNotFoundException;
import com.theraphy.backend.shared.exception.ResourceValidationException;
import com.theraphy.backend.treatments.domain.model.entity.VideoSession;
import com.theraphy.backend.treatments.domain.persistence.VideoSessionRepository;
import com.theraphy.backend.treatments.domain.service.VideoSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class VideoSessionServiceImpl implements VideoSessionService {

    private static final String ENTITY = "VideoSessions";

    private final VideoSessionRepository videoSessionRepository;

    private final Validator validator;

    public VideoSessionServiceImpl(VideoSessionRepository videoSessionRepository, Validator validator) {
        this.videoSessionRepository = videoSessionRepository;
        this.validator = validator;
    }

    @Override
    public List<VideoSession> getAll() {
        return videoSessionRepository.findAll();
    }

    @Override
    public VideoSession getById(Long videoSessionId) {
        return videoSessionRepository.findById(videoSessionId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,videoSessionId));
    }


    @Override
    public VideoSession create(VideoSession videoSession) {
        Set<ConstraintViolation<VideoSession>> violations = validator.validate(videoSession);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return videoSessionRepository.save(videoSession);
    }


    @Override
    public ResponseEntity<?> delete(Long videoSessionId) {
        return videoSessionRepository.findById(videoSessionId).map( videoSession -> {
            videoSessionRepository.delete(videoSession);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,videoSessionId));
    }
}
