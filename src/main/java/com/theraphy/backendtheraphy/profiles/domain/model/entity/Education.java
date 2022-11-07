package com.theraphy.backendtheraphy.profiles.domain.model.entity;

import com.theraphy.backendtheraphy.security.domain.model.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "physiotherapists_universities",
            joinColumns = @JoinColumn(name = "physiotherapist_id"),
            inverseJoinColumns = @JoinColumn(name = "university_id"))
    private Set<University> universities= new HashSet<>();


}
