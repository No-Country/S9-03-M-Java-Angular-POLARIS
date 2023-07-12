package com.polaris.appWebPolaris.dto;

import com.polaris.appWebPolaris.enums.Role;
import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
    private Role role;
    private Long profileId;
    private Long workId;
}
