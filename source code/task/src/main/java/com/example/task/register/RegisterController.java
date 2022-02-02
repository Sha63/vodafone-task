package com.example.task.register;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
@AllArgsConstructor
public class RegisterController {

    private IRegisterRepository registerRepository;

    @GetMapping()
    public String register_get(Model model) {
        RegisterRequest registerRequest = new RegisterRequest();
        model.addAttribute("registerRequest", registerRequest);
        return "register";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String register_post(@Valid RegisterRequest registerRequest, BindingResult result, Model model){
        boolean hasErrors = result.hasErrors();
        if(hasErrors) {
            model.addAttribute("registerRequest", registerRequest);
            return "register";
        }
        try {
            registerRepository.register(registerRequest);
        } catch(IllegalArgumentException e) {
            model.addAttribute("registerRequest", registerRequest);
            model.addAttribute("passwordMatch", e.getMessage());
            return "register";
        } catch(IllegalStateException e) {
            model.addAttribute("registerRequest", registerRequest);
            model.addAttribute("usernameExists", e.getMessage());
            return "register";
        }
        return "redirect:/login";
    }
}
