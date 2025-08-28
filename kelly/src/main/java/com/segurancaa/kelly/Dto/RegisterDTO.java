package com.segurancaa.kelly.Dto;

import com.segurancaa.kelly.role.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
