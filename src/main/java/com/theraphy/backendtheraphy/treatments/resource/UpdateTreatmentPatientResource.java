package com.theraphy.backendtheraphy.treatments.resource;

import com.theraphy.backendtheraphy.profile.resource.PatientResource;
import com.theraphy.backendtheraphy.treatments.domain.model.entity.Treatment;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTreatmentPatientResource {

    @NotNull
    @NotBlank
    @Size(max = 60)
    private Treatment treatment;

    private PatientResource patient;

    @NotNull
    @NotBlank
    private Date registrationDate;

    private Double progress;
}
