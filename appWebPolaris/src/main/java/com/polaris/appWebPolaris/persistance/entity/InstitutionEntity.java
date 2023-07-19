package com.polaris.appWebPolaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "institutions")
@DiscriminatorValue("Institution")
public class InstitutionEntity extends CustomerEntity{

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    private String name;
    private String cuit;
/*    private String email;
    private String password;*/
    private String province;
    private String locality;
    private String type;
    private String availability;
    private String numberphone;
    private String imageProfile;
    @OneToMany(mappedBy = "institution",cascade = CascadeType.ALL)
    private List<VolunteerInstitutionEntity> volunteerInstitutionList;

    /*private String rol;*/

}
