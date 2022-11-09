package com.theraphy.backendtheraphy.profiles.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryResource {
    private Long id;
    private String patientName;
    private Double height;
    private Double weight;
    private Double bodyMass;

}
