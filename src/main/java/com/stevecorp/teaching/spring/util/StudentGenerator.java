package com.stevecorp.teaching.spring.util;

import com.github.javafaker.Faker;
import com.stevecorp.teaching.spring.model.Address;
import com.stevecorp.teaching.spring.model.AddressType;
import com.stevecorp.teaching.spring.model.Name;
import com.stevecorp.teaching.spring.model.Student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;

public class StudentGenerator {

    private static final Faker FAKE_DATA_GENERATOR = new Faker();

    public static Student generateStudent() {
        final Student student = Student.builder()
                .dateOfBirth(utilDateToLocalDate(FAKE_DATA_GENERATOR.date().birthday()))
                .name(Name.builder()
                        .firstName(FAKE_DATA_GENERATOR.name().firstName())
                        .lastName(FAKE_DATA_GENERATOR.name().lastName())
                        .build())
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
        /*
            Do note what we did here. Since in the database we have a one-to many relationship, and the address
             also has a reference to the student, we need to set the student references.
             If we don't do this, the addresses will not be persisted!
         */
        student.getAddresses().forEach(address -> address.setStudent(student));
        return student;
    }

    public static Address generateStudentRoomAddress(final Student student) {
        return Address.builder()
                .addressType(AddressType.STUDENT_ROOM)
                .street(FAKE_DATA_GENERATOR.address().streetName())
                .number(FAKE_DATA_GENERATOR.address().streetAddressNumber())
                .box(FAKE_DATA_GENERATOR.address().buildingNumber())
                .city(FAKE_DATA_GENERATOR.address().cityName())
                .zip(FAKE_DATA_GENERATOR.address().zipCode())
                .student(student)
                .build();
    }

    private static LocalDate utilDateToLocalDate(final Date utilDate) {
        return utilDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
