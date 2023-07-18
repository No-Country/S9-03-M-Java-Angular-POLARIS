package com.polaris.appWebPolaris.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstituteDto {

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
    private String imageProfile;

    private String rol;

    @Override
    public String toString() {
        return "InstituteDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuit='" + cuit + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", province='" + province + '\'' +
                ", locality='" + locality + '\'' +
                ", type='" + type + '\'' +
                ", availability='" + availability + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
