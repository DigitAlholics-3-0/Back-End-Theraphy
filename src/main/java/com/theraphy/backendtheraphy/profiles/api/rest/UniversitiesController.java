package com.theraphy.backendtheraphy.profiles.api.rest;

import com.theraphy.backendtheraphy.profiles.domain.service.UniversityService;
import com.theraphy.backendtheraphy.profiles.mapping.UniversityMapper;
import com.theraphy.backendtheraphy.profiles.resource.CreateUniversityResource;
import com.theraphy.backendtheraphy.profiles.resource.UniversityResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/universities", produces = "application/json")
@Tag(name = "Universities", description = "Create and read universities")
public class UniversitiesController {

    private final UniversityService universityService;

    private final UniversityMapper mapper;

    public UniversitiesController(UniversityService universityService, UniversityMapper mapper) {
        this.universityService = universityService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<UniversityResource> getAllUniversities(Pageable pageable) {
        return mapper.modelListPage(universityService.getAll(), pageable);
    }

    @GetMapping("{universityId}")
    public UniversityResource getUniversityById(@PathVariable Long universityId) {
        return mapper.toResource(universityService.getById(universityId));
    }

    @PostMapping
    public ResponseEntity<UniversityResource> createUniversity(@RequestBody CreateUniversityResource resource) {
        return new ResponseEntity<>(mapper.toResource(universityService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
