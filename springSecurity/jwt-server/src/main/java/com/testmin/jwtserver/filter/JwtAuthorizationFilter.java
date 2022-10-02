package com.testmin.jwtserver.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.testmin.jwtserver.auth.AccountDetails;
import com.testmin.jwtserver.model.Account;
import com.testmin.jwtserver.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/*
 * Jwt Token 에 대한 인가를 담당하는 필터
 * */
@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final AccountRepository accountRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, AccountRepository accountRepository) {
        super(authenticationManager);
        this.accountRepository = accountRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
        * JWT Token 검증
        * */
        String authorize = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorize != null && authorize.startsWith("Bearer ")) {
            String jwt = authorize.replace("Bearer ", "");

            /*
             * 개인키로 JWT 가 정상적으로 복호화가 되었다면, 이 JWT 는 현재 서버에서 발급했다고 취급한다.
             * */
            DecodedJWT verify = JWT.require(Algorithm.HMAC512("mySecretKey")).build().verify(jwt);
            String username = verify.getClaim("username").asString();

            if (username != null && !username.isEmpty()) {
                Optional<Account> accountOptional = accountRepository.findByUsername(username);
                Account account = accountOptional.get();

                AccountDetails accountDetails = new AccountDetails(account);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(accountDetails, null, accountDetails.getAuthorities());

                /*
                 * JWT 로 인증완료 되었을 경우 Authentication 객체를 저장해준다.
                 * */
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}
