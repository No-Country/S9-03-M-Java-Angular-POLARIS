package com.polaris.appWebPolaris.model;

import com.polaris.appWebPolaris.enums.Role;
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
@Entity
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String profileImg;
    //private Role role;
    private String contactNumber;
    private String address;
    private String country;
    private String province;
    private String locality;
    private String availability;
    private String profession;
    private boolean isValidated;
    private boolean experience;
    //@OneToMany
    //private List<Review> reviews;
    private String presentation;
    //private List<String> skills;
    //@OneToMany
    //private List<WorkRequest> workRequests;

}
