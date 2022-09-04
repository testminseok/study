package me.testmain.demospringsecurityform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() // 인가가 필요한 모든 요청들
                .mvcMatchers("/", "/info").permitAll() // 중에 "/"와 "/info" 는 접근을 허용하고
                .mvcMatchers("/admin").hasRole("ADMIN") // "/admin" 요청은 유저에 ADMIN Role 을 가지고 있어야한다.
                .anyRequest().authenticated(); // 그외 모든 요청은 인증을 해야한다.

        http.formLogin();
        http.httpBasic();
    }
}
