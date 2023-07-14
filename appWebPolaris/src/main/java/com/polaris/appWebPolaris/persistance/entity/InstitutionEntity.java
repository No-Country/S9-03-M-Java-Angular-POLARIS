package com.polaris.appWebPolaris.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "institutions")
public class InstitutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cuit;
    private String email;
    private String password;
    private String province;
    private String locality;
    private String type;
    private String availability;
    private String numberphone;

    private String rol;


}
