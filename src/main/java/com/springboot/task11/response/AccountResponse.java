package com.springboot.task11.response;


import com.springboot.task11.constant.AccountType;
import com.springboot.task11.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountResponse {

    private Long accountId;
    private Long accountNumber;
    private String currency;
    private BigDecimal currentBalance;
    private BigDecimal previousBalance;
    private AccountType accountType;
    private CustomerResponse customer;

}
