package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reseña")
public class ReviewEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reseña_id")
    private Long Id;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "calificacion")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "voluntario_id", insertable = false, updatable = false)
    private VolunteerEntity volunteerEntityFK;
}
