package org.example.demo1.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @GetMapping(value = "/show", produces = "text/plain;charset=UTF-8")
    public String getStudents() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/students.txt");
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
