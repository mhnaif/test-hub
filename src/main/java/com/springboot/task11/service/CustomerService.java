package com.springboot.task11.service;


import com.springboot.task11.entity.Customer;
import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.repository.CustomerRepository;
import com.springboot.task11.request.CustomerRequest;
import com.springboot.task11.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest request){
        Customer customer = new Customer();
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setCivilId(request.getCivilId());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setFullName(request.getFullName());
        customer.setDateOfBirth(request.getDateOfBirth());


        Customer saved = customerRepository.save(customer);
        return getCustomerResponse(saved);

    }

    public CustomerResponse getCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found"));
        return getCustomerResponse(customer);
    }

    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        CustomerResponse customer = getCustomer(id);
        customerRepository.deleteById(customer.getCustomerId());
    }

    public CustomerResponse updateCustomer(Long id,CustomerRequest request) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("customer not found"));
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerNumber(request.getCustomerNumber());
        customer.setCivilId(request.getCivilId());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setFullName(request.getFullName());
        customer.setDateOfBirth(request.getDateOfBirth());
        Customer saved = customerRepository.save(customer);

        return getCustomerResponse(saved);
    }

    private CustomerResponse getCustomerResponse(Customer saved) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(saved.getCustomerId());
        response.setCustomerNumber(saved.getCustomerNumber());
        response.setCivilId(saved.getCivilId());
        response.setFullName(saved.getFullName());
        response.setDateOfBirth(saved.getDateOfBirth());
        response.setMobileNumber(saved.getMobileNumber());
        return response;
    }
}
