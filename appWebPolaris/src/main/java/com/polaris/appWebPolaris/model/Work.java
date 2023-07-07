package com.polaris.appWebPolaris.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;
    private String name;
    private String description;
    private Date date;
}
