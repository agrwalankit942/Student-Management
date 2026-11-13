
package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // 1. Home page
    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    // 2. View all students and search students
    @GetMapping("/students")
    public String viewStudents(
            @RequestParam(required = false) String keyword,
            Model model) {

        List<Student> students;

        if (keyword != null && !keyword.trim().isEmpty()) {
            students =
                studentRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                    keyword.trim(), keyword.trim()
                );
        } else {
            students = studentRepository.findAll();
        }

        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword);

        return "students";
    }

    // 3. Display add student form
    @GetMapping("/students/new")
    public String showAddForm(Model model) {

        model.addAttribute("student", new Student());

        return "student-form";
    }

    // 4. Save new student or update existing student
    @PostMapping("/students/save")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "student-form";
        }

        studentRepository.save(student);

        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Student details saved successfully!"
        );

        return "redirect:/students";
    }

    // 5. Display update form
    @GetMapping("/students/edit/{id}")
    public String showEditForm(
            @PathVariable int id,
            Model model,
            RedirectAttributes redirectAttributes) {

        Optional<Student> optionalStudent =
            studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            model.addAttribute("student", optionalStudent.get());
            return "student-form";
        }

        redirectAttributes.addFlashAttribute(
            "errorMessage", "Student not found!"
        );

        return "redirect:/students";
    }

    // 6. Delete student
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(
            @PathVariable int id,
            RedirectAttributes redirectAttributes) {

        if (studentRepository.existsById(id)) {

            studentRepository.deleteById(id);

            redirectAttributes.addFlashAttribute(
                "successMessage",
                "Student deleted successfully!"
            );

        } else {

            redirectAttributes.addFlashAttribute(
                "errorMessage",
                "Student not found!"
            );
        }

        return "redirect:/students";
    }
}
