package com.theraphy.backend.treatments.api.rest;

import com.theraphy.backend.treatments.domain.service.VideoSessionService;
import com.theraphy.backend.treatments.mapping.VideoSessionsMapper;
import com.theraphy.backend.treatments.resource.CreateVideoSessionResource;
import com.theraphy.backend.treatments.resource.VideoSessionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/videoSessions", produces = "application/json")
@Tag(name = "Video Sessions", description = "Create, read, update and delete video sessions")
public class VideoSessionsController {

    private final VideoSessionService videoSessionService;

    private final VideoSessionsMapper mapper;

    public VideoSessionsController(VideoSessionService videoSessionService, VideoSessionsMapper mapper) {
        this.videoSessionService = videoSessionService;
        this.mapper = mapper;
    }

    @GetMapping("{videoSessionId}")
    public VideoSessionResource getVideoSessionId(@PathVariable Long videoSessionId) {
        return mapper.toResource(videoSessionService.getById(videoSessionId));
    }

    @GetMapping
    public Page<VideoSessionResource> getAllVideoSessions(Pageable pageable){
        return mapper.modelListPage(videoSessionService.getAll(),pageable);
    }
    @PostMapping
    public ResponseEntity<VideoSessionResource> createVideoSession(
            @RequestBody CreateVideoSessionResource resource) {
        return new ResponseEntity<>(mapper.
                toResource(videoSessionService.
                        create(mapper.
                                toModel(resource))), HttpStatus.CREATED);
    }
    @DeleteMapping("{videoSessionId}")
    public ResponseEntity<?> deleteVideoSession(@PathVariable Long videoSessionId) {
        return videoSessionService.delete(videoSessionId);
    }
}
