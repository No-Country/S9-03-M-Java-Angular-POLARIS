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
@Table(name = "workRequest")
public class WorkRequest {
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
    @ManyToOne
    @JoinColumn(
            name = "institution_id"
            //nullable = false,
            //foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (institution_id) references institution (institutionId)")
    )
    private Institution institution;

    @OneToOne
    @JoinColumn(
            name = "work_id"
            //nullable = false,
            //foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (work_id) references work (workId)"),
            //insertable = false, updatable = false
    )
    private Work work;
    private String details;
    private String string;

}
