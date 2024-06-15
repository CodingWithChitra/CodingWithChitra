package com.codingwithchitra.codingwithchitra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/course/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course-form";
    }

    @PostMapping("/course")
    public String saveCourse(@RequestParam String title, @RequestParam String description) {
        Course course = new Course();
        course.withTitle(title);
        course.withDescription(description);
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
}