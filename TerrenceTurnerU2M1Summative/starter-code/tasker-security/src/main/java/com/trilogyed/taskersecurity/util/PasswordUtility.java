package com.trilogyed.taskersecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {

        //jsmith - owner
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password123";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);

        //jdoe - reader
//        PasswordEncoder encoder1 = new BCryptPasswordEncoder();
        String password1 = "ThisIsMyPassword";
        String encodedPassword1 = encoder.encode(password1);
        System.out.println(encodedPassword1);


        //djones - reader
//        PasswordEncoder encoder2 = new BCryptPasswordEncoder();
        String password2 = "IHaveAGoodPassword";
        String encodedPassword2 = encoder.encode(password2);
        System.out.println(encodedPassword2);
    }
}
