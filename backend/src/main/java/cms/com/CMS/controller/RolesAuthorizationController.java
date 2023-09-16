package com.login.UserLogin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesAuthorizationController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return " ADMIN";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return " USER";
    }

    @GetMapping("/accessInvited")
    @PreAuthorize("hasRole('GUEST')")
    public String accessInvited(){
        return " GUEST";
    }
}
