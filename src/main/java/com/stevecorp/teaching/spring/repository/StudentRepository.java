package com.stevecorp.teaching.spring.repository;

import com.stevecorp.teaching.spring.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Override
    List<Student> findAll();

    List<Student> findAllByAddressesZip(String zip);

    @Query("SELECT s from Student s WHERE year(s.dateOfBirth) = :year")
    List<Student> findAllBornInYear(final int year);

}
