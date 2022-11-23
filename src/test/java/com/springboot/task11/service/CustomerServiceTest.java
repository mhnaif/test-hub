package com.springboot.task11.service;

import com.springboot.task11.entity.Customer;
import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.repository.CustomerRepository;
import com.springboot.task11.request.CustomerRequest;
import com.springboot.task11.response.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {

    @SpyBean
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenValidAddingCustomer_ThenReturnCustomer() {

        CustomerResponse response = CustomerResponse.builder()
                .customerId(11L)
                .civilId(123L)
                .fullName("mohammed")
                .mobileNumber("1234")
                .customerNumber(123L)
                .dateOfBirth(LocalDate.now()).build();

        Customer customer = new Customer();
        customer.setCustomerId(response.getCustomerId());
        customer.setCivilId(response.getCivilId());
        customer.setFullName(response.getFullName());
        customer.setMobileNumber(response.getMobileNumber());
        customer.setDateOfBirth(response.getDateOfBirth());
        customer.setCustomerNumber(response.getCustomerNumber());

        CustomerRequest request = new CustomerRequest();
        request.setCustomerId(customer.getCustomerId());
        request.setCivilId(customer.getCivilId());
        request.setFullName(customer.getFullName());
        request.setMobileNumber(customer.getMobileNumber());
        request.setDateOfBirth(customer.getDateOfBirth());
        request.setCustomerNumber(customer.getCustomerNumber());



        Mockito.when(customerRepository.save(Mockito.any()))
                .thenReturn(customer);


        CustomerResponse response1 = customerService.addCustomer(request);

        assertEquals(response1,response);


    }

    @Test
    void whenValidGetCustomerById_ThenReturnCustomer() throws CustomerNotFoundException {

        CustomerResponse response = CustomerResponse.builder()
                .customerId(11L)
                .civilId(123L)
                .fullName("mohammed")
                .mobileNumber("1234")
                .customerNumber(123L)
                .dateOfBirth(LocalDate.now()).build();

        Customer customer = new Customer();
        customer.setCustomerId(response.getCustomerId());
        customer.setCivilId(response.getCivilId());
        customer.setFullName(response.getFullName());
        customer.setMobileNumber(response.getMobileNumber());
        customer.setDateOfBirth(response.getDateOfBirth());


        Mockito.when(customerRepository.save(Mockito.any()))
                .thenReturn(customer);

        CustomerResponse customer1 = customerService.getCustomer(11L);

        assertEquals(response,customer1);


    }


}