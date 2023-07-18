package com.polaris.appWebPolaris.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private Long id;
    private String email;
    private String password;
    private String imageProfile;

    private String rol;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
