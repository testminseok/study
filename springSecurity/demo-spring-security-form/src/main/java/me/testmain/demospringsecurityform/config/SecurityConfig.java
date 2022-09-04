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
                .mvcMatchers("/", "/info", "/account/**").permitAll() // 중에 "/"와 "/info" 는 접근을 허용하고
                .mvcMatchers("/admin").hasRole("ADMIN") // "/admin" 요청은 유저에 ADMIN Role 을 가지고 있어야한다.
                .anyRequest().authenticated(); // 그외 모든 요청은 인증을 해야한다.

        http.formLogin();
        http.httpBasic();
    }



    /*
    * Authentication 을 설정할 수 있는 메소드
    * */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*
//        * {noop} 는 Spring Security 5.x 부터 사용하는 기본 패스워드 인코더이다.
//        * 패스워드 prefix 에 해당하는 방식으로 인코딩하여 값을 비교한다.
//        * */
//        auth.inMemoryAuthentication()
//                .withUser("testmin").password("{noop}123123").roles("USER");
//
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}123123").roles("ADMIN");
//    }
}
