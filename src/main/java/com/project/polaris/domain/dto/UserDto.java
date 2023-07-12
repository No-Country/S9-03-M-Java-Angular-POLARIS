package com.project.polaris.domain.dto;

import com.project.polaris.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String email;
    private String profileImg;
    private String contactNumber;
    private Role role;
}
