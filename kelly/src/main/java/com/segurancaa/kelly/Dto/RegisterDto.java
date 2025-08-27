package com.segurancaa.kelly.Dto;

import com.segurancaa.kelly.role.UserRole;

public record RegisterDto (
        String login,
        String password,
        UserRole role

){}

