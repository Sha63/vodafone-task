package com.example.task.register;

import com.example.task.customer.Customer;
import com.example.task.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService implements IRegisterRepository{

    private CustomerService customerService;
    private PasswordValidator passwordValidator;

    public String register(RegisterRequest request) {
        if(!passwordValidator.validate(request)) {
            throw new IllegalArgumentException("Passwords must match");
        }
        customerService.register(new Customer(request));
        return "success";
    }
}
