package com.project.polaris.persistance.entity;
import com.project.polaris.enums.InterviewState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entrevista")
public class InterviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrevista_id")
    private Long Id;

    @Column(name = "fecha_entrevista")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInterview;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private InterviewState state;

    @ManyToOne
    @JoinColumn(name = "voluntario_id", insertable = false, updatable = false)
    private VolunteerEntity volunteerEntityFK;

    @ManyToOne
    @JoinColumn(name = "institucion_id", insertable = false, updatable = false)
    private InstitutionEntity institutionEntityFK;


}
