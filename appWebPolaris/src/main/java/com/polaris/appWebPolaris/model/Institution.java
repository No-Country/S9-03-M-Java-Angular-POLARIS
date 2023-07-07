package com.polaris.appWebPolaris.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Institution extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long institutionId;
    private String name;
    private String type;
    private String availability;
    private List<Work> works;
    private Integer postalCode;
    @OneToMany
    private List<WorkRequest> workRequests;
}
