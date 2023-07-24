package com.polaris.appWebPolaris.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseReviewDto {
    private String name;
    private String image;
    private String comment;
    private String locality;
}
