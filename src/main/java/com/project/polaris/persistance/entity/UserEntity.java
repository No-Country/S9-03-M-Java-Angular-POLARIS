package com.project.polaris.persistance.entity;

import com.project.polaris.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="rol", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ROLE_ADMIN")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Email
    @NotBlank
    @Column(name = "correo", unique = true)
    private String email;

    @NotBlank
    @Column(name = "contraseña")
    private String password;

    @Column(name = "foto_perfil")
    private String profileImg;

    @Column(name = "numero_telefono")
    private String contactNumber;

    @Column(name = "rol", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
