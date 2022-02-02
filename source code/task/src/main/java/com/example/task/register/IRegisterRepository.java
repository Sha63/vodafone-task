package com.example.task.register;

import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository {
    String register(RegisterRequest registerRequest);
}
