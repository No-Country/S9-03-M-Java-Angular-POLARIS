package com.polaris.appWebPolaris.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volunteerId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String availability;
    private String profession;
    private boolean isValidated;
    private boolean experience;
    @OneToMany
    private List<Review> reviews;
    private String presentation;
    private List<String> skills;
    @OneToMany
    private List<WorkRequest> workRequests;

}
