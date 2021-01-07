package com.ljp.test.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private String className;
    private String studentNo;
    private String studentName;
    private double score;
    private int rank;

}
