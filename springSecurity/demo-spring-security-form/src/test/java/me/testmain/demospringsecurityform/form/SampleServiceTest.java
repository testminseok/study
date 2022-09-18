package me.testmain.demospringsecurityform.form;

import me.testmain.demospringsecurityform.account.Account;
import me.testmain.demospringsecurityform.account.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@SpringBootTest
class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Autowired
    AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Test
    @DisplayName("메소드에서 권한 확인")
    void dashboard() {
        Account account = new Account();
        account.setRole("ADMIN");
        account.setUsername("testmin");
        account.setPassword("123123");
        accountService.createNew(account);

        UserDetails userDetails = accountService.loadUserByUsername("testmin");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, "123123");

        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        sampleService.dashboard();
    }

}