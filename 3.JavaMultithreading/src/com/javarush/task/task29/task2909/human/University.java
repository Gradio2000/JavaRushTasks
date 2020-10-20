package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        super(name, age);
    }

    public Student getStudentWithAverageGrade(double averagegrade) {
        for (Student student : students){
            if (student.getAverageGrade() == averagegrade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = Double.MIN_VALUE;
        Student best = null;
        for (Student student : students){
            if (student.getAverageGrade() > max){
                max = student.getAverageGrade();
                best = student;
            }
        }
        return best;
    }


    public Student getStudentWithMinAverageGrade(){
        double min = Double.MAX_VALUE;
        Student loser = null;
        for (Student student : students){
            if (student.getAverageGrade() < min){
                min = student.getAverageGrade();
                loser = student;
            }
        }
        return loser;
    }
    public void expel(Student student){
        students.remove(student);
    }
}