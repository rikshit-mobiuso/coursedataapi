package com.example.coursedataapi.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAuthorization {

    @GetMapping("/student")
    public String student(){
        return("<h1>Welcome Student</h1>");
    }

    @GetMapping("/teacher")
    public String teacher(){
        return("<h1>Welcome Teacher</h1>");
    }

    @GetMapping("/")
    public String admin(){
        return("<h1>Welcome Admin</h1>");
    }
}