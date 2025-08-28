package com.segurancaa.kelly.role;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    ADMIN("admin"),
    USER("user");
    private String role;
    UserRole(String role) {
        this.role=role;
    }
    @JsonValue
    private String getRole(){
        return role;
    }
    @JsonCreator
    public static UserRole  FromValue(String value){
        for(UserRole role:UserRole.values()){
            if(role.role.equalsIgnoreCase(value)){
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: "+value);
    }
}
