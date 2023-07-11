package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publicacion")
public class PublishingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publicacion_id")
    private Long publishingId;

    @Column(name = "titulo")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @ManyToOne
    @JoinColumn(name = "institucion_id", insertable = false, updatable = false)
    private InstitutionEntity institutionEntityFK;

    @OneToMany(mappedBy = "publishingEntity")
    private List<KnowledgePublishingEntity> knowledgePublishingEntities;
}
