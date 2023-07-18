package com.polaris.appWebPolaris.security;

public enum Roles {

    VOLUNTEER("Volunteer"),
    INSTITUTION("Institution");

    private String name;

    Roles(String name) {
        this.name = name;
    }

}
