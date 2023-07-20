package com.polaris.appWebPolaris.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {

    private Long id;
    private String comment;
    private LocalDate date;
    private Integer rating;
    private Long idVolunteer;
    private Long idInstitution;
}
