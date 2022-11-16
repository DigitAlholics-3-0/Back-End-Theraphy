package com.theraphy.backendtheraphy.treatments.api.rest;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.TreatmentPatient;
import com.theraphy.backendtheraphy.treatments.domain.service.TreatmentPatientService;
import com.theraphy.backendtheraphy.treatments.domain.service.TreatmentService;
import com.theraphy.backendtheraphy.treatments.mapping.TreatmentMapper;
import com.theraphy.backendtheraphy.treatments.mapping.TreatmentPatientMapper;
import com.theraphy.backendtheraphy.treatments.resource.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/treatments_by_patient", produces = "application/json")
@Tag(name = "Treatments By Patient", description = "Create, read, update and delete treatments by patient")
public class TreatmentsPatientController
{
    private final TreatmentPatientService treatmentPatientService;

    private final TreatmentPatientMapper mapper;

    public TreatmentsPatientController( TreatmentPatientService treatmentPatientService, TreatmentPatientMapper mapper) {
        this.treatmentPatientService = treatmentPatientService;
        this.mapper = mapper;
    }


   @GetMapping
    public Page<TreatmentPatientResource> getAllTreatments(Pageable pageable) {
        return mapper.modelListPage(treatmentPatientService.getAll(), pageable);
    }

    @GetMapping("{treatmentByPatientId}")
    public TreatmentPatientResource getTreatmentPatientById(@PathVariable Long treatmentByPatientId) {
        return mapper.toResource(treatmentPatientService.getById(treatmentByPatientId));
    }

    @PostMapping
    public ResponseEntity<TreatmentPatientResource> createTreatmentPatient(@RequestBody CreateTreatmentPatientResource resource) {
        return new ResponseEntity<>(mapper.toResource(treatmentPatientService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{treatmentId}")
    public TreatmentPatientResource updateTreatmentPatient(@PathVariable Long treatmentId,
                                             @RequestBody UpdateTreatmentPatientResource resource) {
        return mapper.toResource(treatmentPatientService.update(treatmentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{treatmentId}")
    public ResponseEntity<?> deleteTreatment(@PathVariable Long treatmentId) {
        return treatmentPatientService.delete(treatmentId);
    }
}
