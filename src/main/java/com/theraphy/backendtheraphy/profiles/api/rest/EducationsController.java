package com.theraphy.backendtheraphy.profiles.api.rest;

import com.theraphy.backendtheraphy.profiles.domain.service.EducationService;
import com.theraphy.backendtheraphy.profiles.mapping.EducationMapper;
import com.theraphy.backendtheraphy.profiles.resource.CreateEducationResource;
import com.theraphy.backendtheraphy.profiles.resource.EducationResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/educations", produces = "application/json")
@Tag(name = "Educations", description = "Create and read educations")
public class EducationsController {

    private final EducationService educationService;

    private final EducationMapper mapper;

    public EducationsController(EducationService educationService, EducationMapper mapper) {
        this.educationService = educationService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<EducationResource> getAllEducations(Pageable pageable) {
        return mapper.modelListPage(educationService.getAll(), pageable);
    }

    @GetMapping("{educationId}")
    public EducationResource getEducationById(@PathVariable Long educationId) {
        return mapper.toResource(educationService.getById(educationId));
    }

    @PostMapping
    public ResponseEntity<EducationResource> createEducation(@RequestBody CreateEducationResource resource) {
        return new ResponseEntity<>(mapper.toResource(educationService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
