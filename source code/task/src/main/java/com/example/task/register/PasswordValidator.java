package com.example.task.register;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@NoArgsConstructor
public class PasswordValidator {
    public boolean validate(RegisterRequest request) {
        return request.getPassword().equals(request.getRepassword());
    }
}
