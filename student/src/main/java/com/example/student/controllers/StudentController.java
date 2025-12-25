package com.example.student.controllers;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Student APIs", description = "CRUD Operations For Students")
@EnableMethodSecurity
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger log =
            LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @Operation(summary = "Create a New Student")
    @PostMapping
    public Student createStudent(@Valid @RequestBody StudentDto dto){
        log.info("Creating student with email: {}", dto.getEmail());

         return studentService.createStudent(dto);
    }

    @Operation(summary = "Get all Students")
    @GetMapping
    public List<Student> getAllStudents(){
         return studentService.getAllStudents();
    }

    @GetMapping("/page")
    public Page<Student> getStudents(
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @Operation(summary = "Get Student By Id")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        log.debug("Fetching student with id: {}", id);

        return studentService.getStudentById(id);
    }

    @Operation(summary = "Update Student By Id")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@Valid @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @Operation(summary = "Delete Student By Id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
