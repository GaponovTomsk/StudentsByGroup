package com.alexander.studentsbygroup;

import com.alexander.studentsbygroup.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentsController {


    private StudentRepository studentRepository;
    private StudentService studentService;

    public StudentsController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String sort, Model model){
        List<Student> studentList;
        if (sort == null) {
            studentList = studentService.findAll();
        } else {
            studentList = studentService.findAllOrderBy(sort);
        }

        model.addAttribute("students",studentList);
        return "index";
    }


}
