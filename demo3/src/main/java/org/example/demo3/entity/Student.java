package org.example.demo3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String sno;
    private String name;
    private String college;
    private String major;
    private String className;
    private Integer registerYear;
    private String avatar;
    private String note;
}
