package com.testmin.jwtserver.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testmin.jwtserver.auth.AccountDetails;
import com.testmin.jwtserver.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * spring security 에서는 form 로그인을 담당하는 필터가 UsernamePasswordAuthenticationFilter 이다.
 * */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("JwtAuthenticationFilter : 로그인");

        // username, password 검증

        ObjectMapper om = new ObjectMapper();
        try {
            Account account = om.readValue(request.getInputStream(), Account.class);
            log.info("account : " + account);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword());

            Authentication authentication = getAuthenticationManager().authenticate(authenticationToken);
            AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();

            log.info("accountDetails.getUsername() : " + accountDetails.getUsername());

            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
