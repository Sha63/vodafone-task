package com.example.task.login;

import com.example.task.customer.Customer;
import com.example.task.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private final CustomerService customerService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping()
    public String index(Model model) {
        Customer customer = customerService.getAuthenticatedCustomer();
        model.addAttribute("firstname", customer.getFirstname());
        return "index";
    }
}
