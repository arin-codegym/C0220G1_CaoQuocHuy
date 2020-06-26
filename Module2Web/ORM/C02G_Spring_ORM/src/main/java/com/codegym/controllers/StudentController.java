package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("studentAbc", new Student("Tien", "2k"));
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
//        student.setId((int)(Math.random() * 1000000));
        studentService.save(student);
        String message = "Dang ky thanh cong";
        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("hung", "giu duoc nhieu cai");

        // repository.findAll();

        return "redirect:/list";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("listOfStudents", studentService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String showInfo(@RequestParam Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/detail/{id}")
    public String showInfoPathVariable(@PathVariable Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }
}
