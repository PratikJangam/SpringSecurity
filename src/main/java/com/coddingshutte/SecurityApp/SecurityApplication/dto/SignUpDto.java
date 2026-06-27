package com.coddingshutte.SecurityApp.SecurityApplication.dto;

import com.coddingshutte.SecurityApp.SecurityApplication.entity.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {

    private String email;
    private String password;
    private String name;
    private Set<Role> roles;
}
