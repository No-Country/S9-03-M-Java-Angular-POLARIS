package com.polaris.appWebPolaris.model;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Review {
    private Long reviewId;
    @ManyToOne
    @JoinColumn(
            name = "volunteer_id",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (volunteer_id) references volunteer (volunteerId)")
    )
    private Volunteer volunteer;
    private String comment;
    private Integer rating;
}
