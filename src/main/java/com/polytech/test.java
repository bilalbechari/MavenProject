package com.polytech;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {

    public static void main(String[] args) {
        String password = new BCryptPasswordEncoder().encode("bilal");
        System.out.println(password);
    }
}
