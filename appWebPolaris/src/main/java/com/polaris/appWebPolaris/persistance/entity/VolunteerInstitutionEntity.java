package com.polaris.appWebPolaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "volunteers_institution")
public class VolunteerInstitutionEntity {

    @EmbeddedId
    private VolunteerInstitutionEntityPK id;
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "idVolunteer", nullable = false, updatable = false,insertable = false)
    private VolunteerEntity volunteer;
    @ManyToOne
    @JoinColumn(name = "idInstitution", nullable = false, updatable = false,insertable = false)
    private InstitutionEntity institution;

}
