package com.stevecorp.teaching.spring.service;

import com.stevecorp.teaching.spring.model.Student;
import com.stevecorp.teaching.spring.repository.StudentRepository;
import com.stevecorp.teaching.spring.service.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(final long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There exists not student with id " + id + "!"));
    }

    public List<Student> getStudentsWithAddressInCity(final String zipCode) {
        return studentRepository.findAllByAddressesZip(zipCode);
    }

    public List<Student> getStudentsBornInYear(final int year) {
        return studentRepository.findAllBornInYear(year);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(final Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(final long id, final Student student) {
        final boolean studentExists = studentRepository.existsById(id);
        if (!studentExists) {
            throw new StudentNotFoundException(id);
        }
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(final long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
