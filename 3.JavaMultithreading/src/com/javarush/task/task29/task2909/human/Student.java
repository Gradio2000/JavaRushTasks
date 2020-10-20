package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {

    private double averageGrade;
    private int course;

    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }


    public int getCourse() {
        return course;
    }


    public void live() {
        learn();
    }

    public void learn() {
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }




    @Override
    public String getPosition() {
        return "Студент" ;
    }

}