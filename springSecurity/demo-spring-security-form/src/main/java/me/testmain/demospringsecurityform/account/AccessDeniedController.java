package me.testmain.demospringsecurityform.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AccessDeniedController {

    @GetMapping("/access-denied")
    public String accessDenied(Model model, Principal principal) {

        if (principal == null) {

        } else {
            model.addAttribute("name", principal.getName());
        }

        return "access-denied";
    }
}
