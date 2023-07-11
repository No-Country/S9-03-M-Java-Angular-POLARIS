package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("ROLE_VOLUNTEER")
public class VolunteerEntity extends UserEntity{

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "genero")
    private String gender;

    @Column(name = "fecha_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Column(name = "profesion")
    private String profession;

    @Column(name = "activo")
    private boolean isActive;

    @Column(name = "experiencia")
    private boolean experience;

    @Column(name = "presentacion")
    private String presentation;

    @OneToOne
    @JoinColumn(name = "ubicacion_id", referencedColumnName = "ubicacion_id")
    private LocationEntity locationEntity;

    @OneToMany(mappedBy = "volunteerEntityFK")
    private List<ReviewEntity> reviewEntity;

    @OneToMany(mappedBy = "volunteerEntityFK")
    private List<InterviewEntity> interviewEntityList;

    @OneToMany(mappedBy = "volunteerEntity")
    private List<KnowledgeVolunteerEntity> knowledgeVolunteerList;

}
