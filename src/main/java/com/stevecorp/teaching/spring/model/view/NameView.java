package com.stevecorp.teaching.spring.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameView {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
