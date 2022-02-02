package com.example.task.register;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {


    @Test
    void passwordsMatchThenShouldReturnTrue() {
        PasswordValidator passwordValidator = new PasswordValidator();
        RegisterRequest registerRequest = new RegisterRequest(
            "",
            "",
            "",
            "asd",
            "asd",
            "",
            ""
        );

        assertTrue(passwordValidator.validate(registerRequest));
    }

    @Test
    void passwordsDonotMatchThenShouldReturnFalse() {
        PasswordValidator passwordValidator = new PasswordValidator();
        RegisterRequest registerRequest = new RegisterRequest(
                "",
                "",
                "",
                "asd",
                "asdad",
                "",
                ""
        );

        assertFalse(passwordValidator.validate(registerRequest));
    }
}