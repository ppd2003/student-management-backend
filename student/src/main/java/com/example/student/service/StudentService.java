package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    private static final Logger log =
            LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private final StudentRepository studentRepository;

    //Constructor Injection( BEST Practice)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student createStudent(StudentDto dto) {
        log.info("Saving student to database");

        Student student = new Student(
                dto.getName(),
                dto.getEmail(),
                dto.getAge()
        );
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        log.debug("Looking for student with id {}", id);

        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Student not found with id {}", id);
                    return new StudentNotFoundException(id);
                });
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent){
        Student existingStudent=studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

        //update fields
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());

        //Save Updated Student
        return studentRepository.save(existingStudent);

    }


}
