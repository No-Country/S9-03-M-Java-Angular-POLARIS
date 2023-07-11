package com.project.polaris.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ubicacion")
@Entity
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_id")
    private Long id;

    @Column(name = "direccion")
    private String address;

    @Column(name = "pais")
    private String country;

    @Column(name = "provincia")
    private String province;

    @Column(name = "localidad")
    private String locality;
}
