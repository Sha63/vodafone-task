package com.example.task.register;

import com.example.task.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@WebMvcTest(RegisterController.class)
class RegisterControllerTest {

    @MockBean
    private IRegisterRepository registerRepository;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegisterViewTest() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest();
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("register"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("registerRequest"));
    }

    @Test
    void registerCustomerWithProperArgumentsTest() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .content(registerRequest.UrlEncoding())
                .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/login"));

    }

    @Test
    void registerCustomerWithEmptyFirstname() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithShortFirstname() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "as",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyLastname() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithShortLastname() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "as",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyUsername() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithShortUsername() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "as",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithExistingUsername() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenThrow(new IllegalStateException("error message"));
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("usernameExists"))
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyPassword() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithShortPassword() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasda",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithLongPassword() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasdasdasdasdasd",
                "asdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyPasswordConfirm() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithShortPasswordConfirm() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "",
                "asd",
                "asd",
                "asdasdasd",
                "asdasda",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithLongPasswordConfirm() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasdasdasdasdasd",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithUnmatchingPasswordConfirm() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasda",
                "asd@asd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenThrow(new IllegalArgumentException("error message"));
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("passwordMatch"))
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyEmail() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithInvalidEmail() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asdasd",
                "01285359332"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithEmptyPhone() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                ""
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }

    @Test
    void registerCustomerWithInvalidPhone() throws Exception{
        RegisterRequest registerRequest = new RegisterRequest(
                "asd",
                "asd",
                "asd",
                "asdasdasd",
                "asdasdasd",
                "asd@asd",
                "0128535933a"
        );

        when(registerRepository.register(registerRequest)).thenReturn("success");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(registerRequest.UrlEncoding())
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().hasErrors())
                .andExpect(MockMvcResultMatchers.view().name("register"));
    }
}