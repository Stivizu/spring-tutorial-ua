package com.stevecorp.teaching.spring.service;

import com.github.javafaker.Faker;
import com.stevecorp.teaching.spring.model.Address;
import com.stevecorp.teaching.spring.model.AddressType;
import com.stevecorp.teaching.spring.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentService {

    private static final Faker FAKE_DATA_GENERATOR = new Faker();

    public List<Student> getAllStudents() {
        return IntStream.range(0, 10)
                .mapToObj(index -> generateStudent())
                .collect(Collectors.toList());
    }

    /*
        Since we don't have any persistence layer yet, we'll generate some fake data using the Java Faker dependency.
     */
    private Student generateStudent() {
        return Student.builder()
                .firstName(FAKE_DATA_GENERATOR.name().firstName())
                .lastName(FAKE_DATA_GENERATOR.name().lastName())
                .dateOfBirth(utilDateToLocalDate(FAKE_DATA_GENERATOR.date().birthday()))
                .addresses(Collections.singletonList(
                        Address.builder()
                                .addressType(AddressType.DOMICILE)
                                .street(FAKE_DATA_GENERATOR.address().streetName())
                                .number(FAKE_DATA_GENERATOR.address().streetAddressNumber())
                                .box(FAKE_DATA_GENERATOR.address().buildingNumber())
                                .city(FAKE_DATA_GENERATOR.address().cityName())
                                .zip(FAKE_DATA_GENERATOR.address().zipCode())
                                .build()
                ))
                .build();
    }

    private LocalDate utilDateToLocalDate(final Date utilDate) {
        return utilDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
