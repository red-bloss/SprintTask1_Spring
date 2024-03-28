package com.example.demo.controllers;

import com.example.demo.model.DBManager;
import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String getUsersPage(Model model){
        ArrayList<Student> students = (ArrayList<Student>) DBManager.getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(value = "/addStudent")
    public String addStudent(){
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        DBManager.addStudent(student);
        return "redirect:/";
    }


}
