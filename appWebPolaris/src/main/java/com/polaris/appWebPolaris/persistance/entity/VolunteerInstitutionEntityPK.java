package com.polaris.appWebPolaris.persistance.entity;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@Embeddable
public class VolunteerInstitutionEntityPK implements java.io.Serializable {


    private Long idVolunteer;
    private Long idInstitution;
    @Serial
    private static final long serialVersionUID = -2145479604343286721L;
}
