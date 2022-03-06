package com.stevecorp.teaching.spring.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentView {

    private Long id;

    private NameView name;

    @Past
    @NotNull
    private LocalDate dateOfBirth;

    private List<AddressView> addresses;

}
