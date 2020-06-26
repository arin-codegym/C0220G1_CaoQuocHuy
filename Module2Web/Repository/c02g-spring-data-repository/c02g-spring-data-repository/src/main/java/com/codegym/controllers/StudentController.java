package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.ClassStudentService;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClassStudentService classStudentService;

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("studentAbc", new Student("Tien", "2k"));
        model.addAttribute("listClasses", classStudentService.findAll());
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
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {

        String keywordLast = null;
        if (keyword.isPresent()) {
            keywordLast = keyword.get();
            model.addAttribute("listOfStudents", studentService.findAllByName(keywordLast, pageable));
        } else {
            model.addAttribute("listOfStudents", studentService.findAll(pageable));
        }

        model.addAttribute("keyword", keywordLast);
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
