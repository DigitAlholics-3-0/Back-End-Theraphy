package com.theraphy.backendtheraphy.profiles.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "degrees")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 240)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "physiotherapists_degrees",
            joinColumns = @JoinColumn(name = "physiotherapist_id"),
            inverseJoinColumns = @JoinColumn(name = "degree_id"))
    private Set<Degree> degrees= new HashSet<>();

}
