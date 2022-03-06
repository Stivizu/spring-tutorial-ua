package com.stevecorp.teaching.spring.service;

import com.stevecorp.teaching.spring.model.Student;
import com.stevecorp.teaching.spring.repository.StudentRepository;
import com.stevecorp.teaching.spring.service.exception.StudentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    public Page<Student> getStudentsWithAddressInCity(
            final String zipCode,
            final Pageable pageable
    ) {
        return studentRepository.findAllByAddressesZipAndActiveTrue(zipCode, pageable);
    }

    public Page<Student> getStudentsBornInYear(
            final int year,
            final Pageable pageable
    ) {
        return studentRepository.findAllBornInYearAndActiveTrue(year, pageable);
    }

    public Page<Student> getAllStudents(final Pageable pageable) {
        return studentRepository.findAllByActiveTrue(pageable);
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

    /*
        Notice how this time we do need to add the @Transactional here, as well as the @Modifying on the Repository query, since we are now using custom queries.
     */
    @Transactional
    public void deleteStudent(final long id) {
        studentRepository.softDeleteById(id);
    }

    @Transactional
    public void deleteAllStudents() {
        studentRepository.softDeleteAll();
    }

}
