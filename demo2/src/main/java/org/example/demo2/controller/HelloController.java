package org.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping("/show")
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }
}
