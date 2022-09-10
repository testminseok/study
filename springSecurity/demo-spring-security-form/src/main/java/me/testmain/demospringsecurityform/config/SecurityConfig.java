package me.testmain.demospringsecurityform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        /*
        * SpringSecurity FilterSecurityInterceptor 에서 AuthorizationFilter 로 교체 중 이다.
        * 기본적으로 하위호환성 을 위해 FilterSecurityInterceptor 를 지원한다.
        * AuthorizationFilter 에서는 AccessDecisionManager 를 사용하지 않는다.
        * FilterSecurityInterceptor 처럼 AuthorizationFilter 도 SecurityFilterChain 의 가장 마지막에 위치한다.
        *
        * 권한이 필요한 페이지를 익명사용자가 요청하면 /login 으로 가게 되는 이유는 아래와 같다.
        * FilterChain 에서 발생하는 AccessDeniedException 과 AuthenticationException 은
        * ExceptionTranslationFilter 에서 처리한다.
        * 하지만, UsernamePasswordAuthenticationFilter 에서 발생한 AccessDeniedException 은
        * UsernamePasswordAuthenticationFilter 내부에서 처리한다.
        * */
        http.authorizeHttpRequests()
                .mvcMatchers("/", "/info", "/account/**").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .mvcMatchers("/user").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        http.formLogin();
        http.httpBasic();

        return http.build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests() // 인가가 필요한 모든 요청들
//                .mvcMatchers("/", "/info", "/account/**").permitAll() // 중에 "/"와 "/info" 는 접근을 허용하고
//                .mvcMatchers("/admin").hasRole("ADMIN") // "/admin" 요청은 유저에 ADMIN Role 을 가지고 있어야한다.
//                .anyRequest().authenticated(); // 그외 모든 요청은 인증을 해야한다.
//
//        http.formLogin();
//        http.httpBasic();
//    }



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
