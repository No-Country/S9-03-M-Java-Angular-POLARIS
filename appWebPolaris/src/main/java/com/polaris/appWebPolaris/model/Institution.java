package com.polaris.appWebPolaris.model;

import com.polaris.appWebPolaris.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String profileImg;
    //private Role role;
    private String contactNumber;
    private String address;
    private String country;
    private String province;
    private String locality;
    private String type;
    private String availability;
    //private List<Work> works;
    private Integer postalCode;
    //@OneToMany
    //private List<WorkRequest> workRequests;
}
