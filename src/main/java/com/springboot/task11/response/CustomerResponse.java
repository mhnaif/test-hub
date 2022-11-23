package com.springboot.task11.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponse {
    private Long customerId;
    private Long customerNumber;
    private Long civilId;
    private LocalDate dateOfBirth;
    private String fullName;
    private String mobileNumber;
}
