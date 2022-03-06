package com.stevecorp.teaching.spring.model.view;

import com.stevecorp.teaching.spring.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentViewMapper {

    StudentView toView(Student student);

    Student toDomain(StudentView studentView);

}
