package com.example.webapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Demoapi")
@RestController
public class DemoapiController {
    @GetMapping("/get")
    public String getString() {
        return "ok";
    }
}
