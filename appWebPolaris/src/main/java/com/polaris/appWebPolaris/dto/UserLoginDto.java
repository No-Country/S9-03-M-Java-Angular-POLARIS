package com.polaris.appWebPolaris.dto;

import com.polaris.appWebPolaris.enums.Role;
import com.polaris.appWebPolaris.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;
    private Role role;
    private UserProfile profile;
}
