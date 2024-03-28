package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static long id = 6L;

    static {
        students.add(new Student(1L, "Alex", "Albon", 47,"F"));
        students.add(new Student(2L, "Charles", "Leclerc", 64,"C"));
        students.add(new Student(3L, "Carlos", "Sainz", 88,"B"));
        students.add(new Student(4L, "Max", "Verstappen", 94, "A"));
        students.add(new Student(5L, "Oscar", "Piastri", 57,"D"));
    }

    public static void addStudent(Student student){
        if (student.getExam() > 90){
            student.setMark("A");
        } else if (student.getExam() >= 75 && student.getExam() < 90) {
            student.setMark("B");
        } else if (student.getExam() >= 60  && student.getExam() < 75) {
            student.setMark("C");
        } else if (student.getExam() >= 50 && student.getExam() < 60) {
            student.setMark("D");
        } else if (student.getExam() < 50) {
            student.setMark("F");
        }
        else {
            student.setMark("error");
        }
        students.add(student);
        student.setId(id);
        id++;
    }

    public static List<Student> getStudents(){
        return students;
    }

    public static Student getStudent(Long id){
        return students.stream().filter(stud -> stud.getId() == id).findFirst().orElseThrow();
    }



}
