package com.polaris.appWebPolaris.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "volunteers")
public class VolunteerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dni;
    private Integer age;
    private String gender;
    private String province;
    private String locality;
    private String occupation;
    private String numberCellphone;

    private String rol;


}
