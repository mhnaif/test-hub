package com.springboot.task11.request;



import com.springboot.task11.constant.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRequest {
    @NotNull
    @Length(max = 10)
    private Long accountId;
    @NotNull
    private Long accountNumber;
    @NotBlank
    private String currency;
    @NotNull
    private BigDecimal currentBalance;
    @NotNull
    private BigDecimal previousBalance;
    @NotNull
    private AccountType accountType;
    @NotNull
    private Long customerId;


}
