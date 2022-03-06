package com.stevecorp.teaching.spring.model.entity;

import com.stevecorp.teaching.spring.model.Student;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentEntityMapper {

    StudentEntity toEntity(Student student);

    Student toDomain(StudentEntity studentEntity);

    /*
        This method is used by MapStruct to do something after the mapping has been done.
         Rather than adding a @Mappings annotation, this has way better flexibility for what we want to achieve.
         Do not that this might have some issues when combined with the Lombok builder.
         Which is the main reason why in this phase we only kept the @Builder annotation on the domain objects.
     */
    @AfterMapping
    default void initializeStudentOnStudentAddresses(final Student student, @MappingTarget final StudentEntity studentEntity) {
        studentEntity.getAddresses().forEach(addressEntity -> addressEntity.setStudent(studentEntity));
    }

}
