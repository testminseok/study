package me.testmain.demospringsecurityform.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        /*
        * 기본적으로 브라우저에선 / 로 요청을 보낼땐 /favicon.ico 요청도 같이 보내게 되는데
        * /favicon.ico 는 FilterChainProxy 에서 AccessDeniedException 이 발생되어 처리된다.
        * 때문에 Static Resource 는 SpringSecurity 에서 확인 하지 않도록 WebSecurity 로 ignore 처리한다.
        * */
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations().);
    }
}
