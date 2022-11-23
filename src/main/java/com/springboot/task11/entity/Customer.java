package com.springboot.task11.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;
    @Column(name = "customer_number")
    private Long customerNumber;
    @Column(name = "civil_id")
    private Long civilId;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "mobile_number")
    private String mobileNumber;
}
