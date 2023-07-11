package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conocimiento_voluntario")
public class KnowledgeVolunteerEntity {

    @EmbeddedId
    private KnowledgeVolunteerPK knowledgeVolunteerPK;

    @ManyToOne
    @MapsId(value = "volunteerId")
    @JoinColumn(name = "voluntario_id", insertable = false, updatable = false)
    private VolunteerEntity volunteerEntity;

    @ManyToOne
    @JoinColumn(name = "conocimiento_id", insertable = false, updatable = false)
    private KnowledgeEntity knowledgeEntity;
}
