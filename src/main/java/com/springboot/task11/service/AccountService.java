package com.springboot.task11.service;


import com.springboot.task11.entity.Account;
import com.springboot.task11.entity.Customer;
import com.springboot.task11.execpetion.AccountNotFoundException;
import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.repository.AccountRepository;
import com.springboot.task11.repository.CustomerRepository;
import com.springboot.task11.request.AccountRequest;
import com.springboot.task11.response.AccountResponse;
import com.springboot.task11.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public AccountResponse addAccount(AccountRequest request) throws Exception {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));


        Account account = new Account();

        Long ofAccounts = getNumberOfAccounts(customer.getCustomerId());
        Long typesCountOfSalaryAccount = getAccountTypesCount(customer.getCustomerId());
        if (ofAccounts > 10) {
            throw new Exception("not allowed to have more than 10 accounts");
        }
        if (typesCountOfSalaryAccount > 1) {
            throw new Exception("not allowed to have more than one salary account type");
        }


        account.setAccountId(request.getAccountId());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCustomer(customer);
        Account saved = accountRepository.save(account);

        Customer customer1 = saved.getCustomer();
        return getResponse(saved, customer1);

    }

    public Long getAccountTypesCount(Long customerId) {
        return accountRepository.getAccountTypesCount(customerId);
    }

    public Long getNumberOfAccounts(Long customerId) {
        return accountRepository.getNumberOfAccount(customerId);
    }

    public AccountResponse getAccount(Long id) throws AccountNotFoundException {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found"));
        Customer customer = account.getCustomer();
        return getResponse(account, customer);
    }

    @Transactional
    public AccountResponse updateAccount(Long id, AccountRequest request) throws AccountNotFoundException, CustomerNotFoundException {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("customer not found"));

        account.setAccountId(request.getAccountId());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(request.getAccountNumber());
        account.setCurrency(request.getCurrency());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setPreviousBalance(request.getPreviousBalance());
        account.setCustomer(customer);


        Account saved = accountRepository.save(account);

        Customer customer1 = saved.getCustomer();

        return getResponse(saved, customer1);
    }

    @Transactional
    public void deleteAccount(Long id) throws AccountNotFoundException {
        accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account not found"));
        accountRepository.deleteById(id);
    }


    private AccountResponse getResponse(Account saved, Customer customer1) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(saved.getAccountId());
        response.setAccountType(saved.getAccountType());
        response.setAccountNumber(saved.getAccountNumber());
        response.setCurrency(saved.getCurrency());
        response.setCurrentBalance(saved.getCurrentBalance());
        response.setPreviousBalance(saved.getPreviousBalance());

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer1.getCustomerId());
        customerResponse.setDateOfBirth(customer1.getDateOfBirth());
        customerResponse.setCustomerNumber(customer1.getCustomerNumber());
        customerResponse.setFullName(customer1.getFullName());
        customerResponse.setCivilId(customer1.getCivilId());


        return response;
    }
}
