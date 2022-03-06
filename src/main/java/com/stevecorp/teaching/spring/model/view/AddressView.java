package com.stevecorp.teaching.spring.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressView {

    private Long id;

    @NotNull
    private String addressType;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String box;

    @NotBlank
    private String city;

    @NotBlank
    private String zip;

}
