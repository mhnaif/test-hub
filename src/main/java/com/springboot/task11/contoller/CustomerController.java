package com.springboot.task11.contoller;



import com.springboot.task11.execpetion.CustomerNotFoundException;
import com.springboot.task11.request.CustomerRequest;
import com.springboot.task11.response.CustomerResponse;
import com.springboot.task11.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public CustomerResponse addCustomer(@RequestBody CustomerRequest request){
        return customerService.addCustomer(request);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        customerService.deleteCustomer(id);
        return "Customer has been deleted";
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id,@RequestBody CustomerRequest request) throws CustomerNotFoundException {
        return customerService.updateCustomer(id,request);
    }


}
