package com.ieee.jpa.controller;

import com.ieee.jpa.entity.Student;
import com.ieee.jpa.manager.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentManager studentManager;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("studentList", studentManager.findAll());
        return "students";
    }

    @GetMapping("/student/{id}")
    public String student(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentManager.findById(id));
        return "student";
    }

    @PostMapping("/save")
    public String save(Student student, Model model) {
        Student student1 = studentManager.save(student);
        model.addAttribute("student", student1);
        return "student";
    }

    @GetMapping("/add")
    public String newStudent() {
        return "add";
    }

    @PostMapping("/add")
    public String add(Student student, Model model) {
        studentManager.save(student);
        model.addAttribute("studentList", studentManager.findAll());
        return "students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        studentManager.delete(id);
        model.addAttribute("studentList", studentManager.findAll());
        return "students";
    }
}
