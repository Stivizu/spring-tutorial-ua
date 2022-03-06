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
        return Student.builder()
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
    }

    private static LocalDate utilDateToLocalDate(final Date utilDate) {
        return utilDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
