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
@Table(name = "volunteers")
@DiscriminatorValue("Volunteer")
public class VolunteerEntity extends CustomerEntity{

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    private String firstName;
    private String lastName;
/*    private String email;
    private String password;*/
    private String dni;
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private String gender;
    private String province;
    private String locality;
    private String education;
    private String numberCellphone;
    private String description;
    private String availability;
    private String imageProfile;

    /*private String rol;*/

}