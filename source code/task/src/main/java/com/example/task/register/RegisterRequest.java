package com.example.task.register;

import lombok.*;

import javax.validation.constraints.*;
import java.net.URLEncoder;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RegisterRequest {
    @NotEmpty(message = "First name can't be empty.")
    @Pattern(regexp = "[a-zA-Z]{3,50}", message = "First name must be between 3 and 50 characters.")
    private String firstname;
    @NotEmpty(message = "Last name can't be empty.")
    @Pattern(regexp = "[a-zA-Z]{3,50}", message = "Last name must be between 3 and 50 characters.")
    private String lastname;
    @NotEmpty(message = "Username can't be empty.")
    @Pattern(regexp = "[a-zA-Z0-9]{3,50}", message = "Username must be between 3 and 50 characters.")
    private String username;
    @NotEmpty(message = "Password can't be empty.")
    @Size(min=8, max=20, message = "Password must be between 8 and 20 characters.")
    private String password;
    @NotEmpty(message = "Password confirm can't be empty.")
    @Size(min=8, max=20, message = "Password confirm must be between 8 and 20 characters.")
    private String repassword;
    @NotEmpty(message = "Email can't be empty.")
    @Email(message = "Email is invalid.")
    private String email;
    @NotEmpty(message = "Phone can't be empty.")
    @Pattern(regexp="0[0-9]{10}", message = "Phone is invalid.")
    private String phone;

    @SneakyThrows
    public String UrlEncoding() {
        return "firstname=" + URLEncoder.encode(firstname, "utf-8") +
                "&lastname=" + URLEncoder.encode(lastname, "utf-8") +
                "&username=" + URLEncoder.encode(username, "utf-8") +
                "&password=" + URLEncoder.encode(password, "utf-8") +
                "&repassword=" + URLEncoder.encode(repassword, "utf-8") +
                "&email=" + URLEncoder.encode(email, "utf-8") +
                "&phone=" + URLEncoder.encode(phone, "utf-8");
    }
}
