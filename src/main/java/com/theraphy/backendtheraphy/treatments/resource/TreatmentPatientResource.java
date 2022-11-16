package com.theraphy.backendtheraphy.treatments.resource;

import com.theraphy.backendtheraphy.profile.domain.model.entity.Patient;
import com.theraphy.backendtheraphy.profile.resource.PatientResource;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentPatientResource {

    private Long id;
    private Treatment treatment;
    private PatientResource patient;
    private Date registrationDate;
    private Double progress;
}
