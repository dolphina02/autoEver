package com.kb.shop.controller;

import com.kb.shop.domain.User;
import com.kb.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(User user, RedirectAttributes redirectAttributes) {
        User registeredUser = userService.registerUser(user);
        if (registeredUser != null) {
            redirectAttributes.addFlashAttribute("message", "Registration successful!");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Registration failed!");
            redirectAttributes.addFlashAttribute("messageType", "danger");
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("message", "Invalid username or password!");
            model.addAttribute("messageType", "danger");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out.");
            model.addAttribute("messageType", "success");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}
