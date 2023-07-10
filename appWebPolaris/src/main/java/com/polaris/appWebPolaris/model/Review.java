package com.polaris.appWebPolaris.model;

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
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "volunteer_id"
            //nullable = false,
            //foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (volunteer_id) references volunteer (volunteerId)")
    )
    private Volunteer volunteer;
    private String comment;
    private Integer rating;
}
