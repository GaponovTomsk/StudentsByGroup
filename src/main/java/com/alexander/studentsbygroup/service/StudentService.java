package com.alexander.studentsbygroup.service;

import com.alexander.studentsbygroup.Student;
import com.alexander.studentsbygroup.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllOrderBy(String sortField) {
        if (sortField.equals("name")){
            return studentRepository.findAllSortByFullName();
        } else if(sortField.equals("gender")) {
            return studentRepository.findAllSortByGender();
        } else if(sortField.equals("status")) {
            return studentRepository.findAllSortByStatus();
        } else if(sortField.equals("fundingType")) {
            return studentRepository.findAllSortByFundingType();
        } else if(sortField.equals("groupStudent")) {
            return studentRepository.findAllSortByGroupStudent();
        }else {
            return findAll();
        }
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
