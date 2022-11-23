package com.springboot.task11.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {


    @Length(max = 7)
    @NotNull
    private Long customerId;
    @NotNull
    private Long customerNumber;
    @NotNull
    private Long civilId;
    @NotNull
    private LocalDate dateOfBirth;
    @NotBlank
    private String fullName;
    @NotBlank
    private String mobileNumber;
}
