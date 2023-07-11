package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "conocimiento_publicacion")
public class KnowledgePublishingEntity {

    @EmbeddedId
    private KnowledgePublishingPK knowledgePublishingPK;

    @ManyToOne
    @MapsId(value = "publishingId")
    @JoinColumn(name = "publicacion_id", insertable = false, updatable = false)
    private PublishingEntity publishingEntity;

    @ManyToOne
    @JoinColumn(name = "conocimiento_id", insertable = false, updatable = false)
    private KnowledgeEntity knowledgeEntity;
}
