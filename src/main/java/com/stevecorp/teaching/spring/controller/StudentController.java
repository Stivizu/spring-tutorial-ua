package com.stevecorp.teaching.spring.controller;

import com.stevecorp.teaching.spring.model.Student;
import com.stevecorp.teaching.spring.model.view.StudentView;
import com.stevecorp.teaching.spring.model.view.StudentViewMapper;
import com.stevecorp.teaching.spring.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.stevecorp.teaching.spring.util.StudentGenerator.generateStudent;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;
    private final StudentViewMapper studentMapper;

    public StudentController(
            StudentService studentService,
            StudentViewMapper studentMapper
    ) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<StudentView> getStudent(
            @PathVariable(name = "student_id") final long studentId
    ) {
        final Student student = studentService.getStudent(studentId);
        final StudentView studentView = studentMapper.toView(student);
        return ResponseEntity.ok(studentView);
    }

    @GetMapping
    public ResponseEntity<Page<StudentView>> getStudents(
            @PageableDefault(value = 20, page = 0) @SortDefault(sort = "name.firstName", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(name = "city_zip", required = false) final String cityZip,
            @RequestParam(name = "year_of_birth", required = false) final Integer yearOfBirth
    ) {
        final Page<Student> students;
        if (cityZip != null) {
            students = studentService.getStudentsWithAddressInCity(cityZip, pageable);
        } else if (yearOfBirth != null) {
            students = studentService.getStudentsBornInYear(yearOfBirth, pageable);
        } else {
            students = studentService.getAllStudents(pageable);
        }
        final Page<StudentView> studentViews = students.map(studentMapper::toView);
        return ResponseEntity.ok(studentViews);
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(
            /*
                The @Valid annotation triggers all the validators (both existing and custom)
             */
            @Valid @RequestBody final StudentView studentView
    ) {
        final Student student = studentMapper.toDomain(studentView);
        studentService.addStudent(student);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> addGeneratedStudent() {
        final Student generatedStudent = generateStudent();
        studentService.addStudent(generatedStudent);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{student_id}")
    public ResponseEntity<Void> updateStudent(
            @PathVariable(name = "student_id") final long studentId,
            @Valid @RequestBody final StudentView studentView
    ) {
        final Student student = studentMapper.toDomain(studentView);
        studentService.updateStudent(studentId, student);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{student_id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable(name = "student_id") final long studentId
    ) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.noContent().build();
    }

}
