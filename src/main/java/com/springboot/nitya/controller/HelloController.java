package com.springboot.nitya.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello-world")
public class HelloController {

    @GetMapping()
    public String helloWorld(){
        return "Hello World to the Springboot with daily code buffer";
    }


}
