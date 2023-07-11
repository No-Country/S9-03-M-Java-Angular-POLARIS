package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("ROLE_INSTITUTION")
public class InstitutionEntity extends UserEntity{

    @Column(name = "razon_social")
    private String name;

    @Column(name = "tipo_institucion")
    private String type;

    @Column(name = "codigo_postal")
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "ubicacion_id", referencedColumnName = "ubicacion_id")
    private LocationEntity locationEntity;

    @OneToMany(mappedBy = "institutionEntityFK")
    private List<PublishingEntity> publishingEntityList;

    @OneToMany(mappedBy = "institutionEntityFK")
    private List<InterviewEntity> interviewEntity;

}
