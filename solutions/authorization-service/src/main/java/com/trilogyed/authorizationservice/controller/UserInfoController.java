package com.trilogyed.authorizationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/principal")
public class UserInfoController {

    public Principal getUserInfo(Principal principal) {
        System.out.println("CALLED userinfo");
        return principal;
    }

}
