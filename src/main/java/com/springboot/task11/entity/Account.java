package com.springboot.task11.entity;

import com.springboot.task11.constant.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long accountId;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "currency")
    private String currency;
    @Column(name = "current_balance")
    private BigDecimal currentBalance;
    @Column(name = "previous_balance")
    private BigDecimal previousBalance;
    @Column(name = "account_type")
    private AccountType accountType;
    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
