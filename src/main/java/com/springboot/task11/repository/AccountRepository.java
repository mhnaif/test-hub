package com.springboot.task11.repository;


import com.springboot.task11.entity.Account;
import com.springboot.task11.response.AccountResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<Account,Long> {


    @Query("select COUNT(a) from Account a ,Customer c where 1=1 and a.customer.customerId = c.customerId and c.customerId = :id ")
    Long getNumberOfAccount(Long id);

    @Query("select COUNT(a) from Account a ,Customer c where 1=1 and a.customer.customerId = c.customerId and c.customerId = :id and a.accountType =SALARY ")
    Long getAccountTypesCount(Long id);

}
