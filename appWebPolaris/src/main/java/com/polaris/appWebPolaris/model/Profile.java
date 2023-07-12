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
@Entity
@Table(name = "volunteer")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstNameVolunteer;
    private String lastName;
    private Integer dni;
    private String gender;//mirar esto
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String contactNumber;
    private String address;//me parece que no
    private String country;//mirar esto, podria ser nacionalidad y pais donde vives
    private boolean residential;
    private String availability;
    private String profession;
    private boolean isValidated;
    private boolean experience;
    private String presentation;//suprimimos manejar los skill para que pueda ponerlo aca
    private Integer postalCode;

//    @OneToMany(mappedBy = "profile")
//    private List<Review> reviews;
}
