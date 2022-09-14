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
        * HeaderWriteFilter 는 응답 헤더에 시큐리티 관련 헤더를 추가해준다.
        * XContentTypeOptionsHeaderWriter : Mine Type 스니핑 방어.
        * XXssProtectionHeaderWriter : 브라우저에 내장된 XSS 필터 적용.
        * CacheControlHeadersWriter : 캐스 히스토리 취약점 방어.
        * HstsHeaderWriter : HTTPS 로만 소통하도록 강제.
        * XFrameOptionsHeaderWriter : clickjacking 방어
        *
        * CsrfFilter 는 Csrf 어택을 방어하기 위한 필터이다. (Cross-Site Request Forgery)
        * 브라우저에서도 현재 요청을 보내는곳이 현재 도메인과 일치해야만 요청을 보낸다.
        * Spring Security 에서는 Resource 를 변경하는 요청에 대해서는 서버에서 발급한 CSRF Token 을 사용하여 방지한다.
        * HttpSession 에 CSRF_TOKEN 값을 저장한 뒤 form 요청에 대한 CSRF_TOKEN 값과 비교하여 확인한다.
        *
        * LogoutFilter 는 Logout 을 담당하는 필터이다.
        * Logout 처리 또는 성공 후 처리를 설정할 수 있다.
        *
        * UsernamePasswordAuthenticationFilter 는 Form 로그인은 담당하는 필터이다.
        * AuthenticationManager 를 사용하여 인증 처리를 진행하며, 기본 제공자인 ProviderManager 를 사용하여
        * AuthenticationProvider 를 확장한 DaoAuthenticationProvider 를 통해 인증을 하게 되고,
        * UserDetailsService 의 타입으로 등록된 Bean 이 DaoAuthenticationProvider 에서 진행되는 인증을 처리한다.
        * 
        * DefaultLoginPageGeneratingFilter 는 Spring Security 에서 기본으로 제공하는 login 페이지를 설정해준다.
        * http.formLogin().loginPage("/login"); 처럼 Custom 한 login 페이지를 제공할 수 있는데, 
        * 이러한 경우 DefaultLoginPageGeneratingFilter 는 FilterChainProxy 에서 제외 된다. 
        * 또한 DefaultLogoutPageGeneratingFilter 도 제외되며, logout 페이지도 Custom 한 페이지를 제공해야한다.
        *
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

        http.formLogin()
        	.loginPage("/login")
        	.permitAll();
        
        http.httpBasic(); // Http Basic 을 허용한다. 이때 Https 를 사용해야 보안에 취약하지 않다.

        http.logout().logoutSuccessUrl("/"); // 로그아웃 성공시 "/" 페이지로 이동

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        /*
        * 기본적으로 브라우저에선 / 로 요청을 보낼땐 /favicon.ico 요청도 같이 보내게 되는데
        * /favicon.ico 는 FilterChainProxy 에서 AccessDeniedException 이 발생되어 처리된다.
        * 때문에 Static Resource 는 SpringSecurity 에서 확인 하지 않도록 WebSecurity 로 ignore 처리한다.
        * */
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
