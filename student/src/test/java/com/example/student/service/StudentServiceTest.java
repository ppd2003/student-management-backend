package com.example.student.service;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldCreateStudent() {

        StudentDto dto = new StudentDto();
        dto.setName("Test");
        dto.setEmail("test@gmail.com");
        dto.setAge(20);

        Student savedStudent =
                new Student("Test", "test@gmail.com", 20);

        when(studentRepository.save(any(Student.class)))
                .thenReturn(savedStudent);

        Student result = studentService.createStudent(dto);

        assertNotNull(result);
        assertEquals("Test", result.getName());
        verify(studentRepository, times(1)).save(any());
    }
}
