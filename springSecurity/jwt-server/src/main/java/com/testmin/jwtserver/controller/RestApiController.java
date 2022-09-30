package com.testmin.jwtserver.controller;

import com.testmin.jwtserver.model.Account;
import com.testmin.jwtserver.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public RestApiController(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Account account) {
        Account user = new Account(account.getId(), account.getUsername(), passwordEncoder.encode(account.getPassword()), "ROLE_USER");
        accountRepository.save(user);
        return "ok";
    }
}
