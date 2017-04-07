package com.example.dell.grades;

/**
 * Created by Dell on 2017-04-07.
 */

public class Grade {
    private String name;
    private int grade;

    public Grade(){}

    public Grade(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
