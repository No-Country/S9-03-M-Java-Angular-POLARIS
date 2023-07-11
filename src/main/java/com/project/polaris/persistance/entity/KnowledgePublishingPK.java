package com.project.polaris.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class KnowledgePublishingPK implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    @Column(name = "conocimiento_id")
    private Long knowledgeId;

    @Column(name = "publicacion_id")
    private Long publishingId;
}
