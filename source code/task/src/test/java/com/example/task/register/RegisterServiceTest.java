package com.example.task.register;

import com.example.task.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class RegisterServiceTest {

    @MockBean
    private CustomerService customerService;

    @MockBean
    private PasswordValidator passwordValidator;

    @Test
    void passwordsDonotMatchThrowsException() {
        RegisterService registerService = new RegisterService(customerService, passwordValidator);
        RegisterRequest registerRequest = new RegisterRequest(
                "",
                "",
                "",
                "asdasdasd",
                "asdasdasda",
                "",
                ""
        );
        when(passwordValidator.validate(registerRequest)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> {
            registerService.register(registerRequest);
        });

    }
}