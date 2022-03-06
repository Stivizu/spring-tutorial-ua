package com.stevecorp.teaching.spring.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
    Notice how we needed to add a specifier for the table name since we modified the class name
 */
@Table(name = "Address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressType;

    private String street;

    private String number;

    private String box;

    private String city;

    private String zip;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

}
