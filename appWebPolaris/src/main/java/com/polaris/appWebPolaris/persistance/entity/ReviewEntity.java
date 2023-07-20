package com.polaris.appWebPolaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
@Entity
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private LocalDate date;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "id_volunteer")
    private VolunteerEntity volunteer;
    @ManyToOne
    @JoinColumn(name = "id_institution")
    private InstitutionEntity institution;


}
