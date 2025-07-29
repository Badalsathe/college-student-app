package com.example.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

    @GetMapping("/msg")
    public String getMsg(){

        String msg="Hi Good Morning....";

        System.out.println("Hiiiiiiiiii");

        return msg;
    }

}
