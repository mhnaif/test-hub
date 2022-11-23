package com.springboot.task11.contoller;


import com.springboot.task11.execpetion.AccountNotFoundException;
import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.request.AccountRequest;
import com.springboot.task11.response.AccountResponse;
import com.springboot.task11.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponse addAccount(@RequestBody AccountRequest request) throws Exception {
        return accountService.addAccount(request);
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id) throws AccountNotFoundException {
        return accountService.getAccount(id);
    }

    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable Long id, @RequestBody AccountRequest request) throws AccountNotFoundException, CustomerNotFoundException {
        return accountService.updateAccount(id,request);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) throws AccountNotFoundException {
        accountService.deleteAccount(id);
        return "account has been deleted";
    }

    }
