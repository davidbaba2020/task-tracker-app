package com.decadave.tasktrackerapp.controller;

import com.decadave.tasktrackerapp.models.UserOfApp;
import com.decadave.tasktrackerapp.services.UserOfAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class UserOfAppController {

    private final UserOfAppService userOfAppService;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignInForm (Model model) {
        model.addAttribute("userOfApp", new UserOfApp());
        return "sign-up";
    }

    @PostMapping("/process_registration")
    public String processRegistrationOfAppUser(UserOfApp userOfApp, RedirectAttributes redirect) {
        String msg = userOfAppService.saveNewAppUser(userOfApp);
        if(Objects.equals(msg, "YOU HAVE SUCCESSFULLY REGISTERED")){
            redirect.addAttribute("success", "You have Successfully registered, log in and get started");
            return "redirect:/";
        }else {
            redirect.addAttribute("error", "An error occured, try again");
            return "sign-up";
        }
    }
}
