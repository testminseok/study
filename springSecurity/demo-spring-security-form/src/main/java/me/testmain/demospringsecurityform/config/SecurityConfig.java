package me.testmain.demospringsecurityform.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        * BasicAuthenticationFilter HttpBasic 의 처리를 담당하는 Filter
        * HttpBasic 을 사용하여 인증을 하기 위해선 HttpHeader 에 Authorization Basic Base64.encode("username:password") 의 형태로
        * 요청을 보내야한다. HttpHeader 에 인증에 필요한 정보가 노출되기 때문에 보안에 취약하며, 반드시 HTTPS 로 해당 요청을 처리해야한다.
        * 또한 HttpBasic 인증은 Form 을 통한 요청과는 다르게 SecurityContext 정보를 저장하지 않기 때문에 매 요청마다 Basic 에 사용자 인증정보를 보내야한다.
        * 
        * RequestCacheAwareFilter 는 현재 요청과 관련있는 캐시된 요청이 있는지 찾아서 적용한다.
        * ex) 사용자 권한이 필요한 페이지(/dashboard)를 익명사용자가 요청하였을때 /login 화면으로 이동된다. 이때 /dashboard 로 온 요청을 캐싱해둔다.
        *  로그인 완료시 처음 캐싱된 Request 를 사용하여 /dashboard 의 요청을 처리한다.
        *  
        * SecurityContextHolderawareRequestFilter 는 시큐리티 관련 서블릿 API 를 구현을 담당한다.
        * - HttpServletRequest#authenticate
        * - HttpServletRequest#login
        * - HttpServletRequest#logout
        * - AsyncContext#start 
        * 
        * AnonymousAuthenticationFilter 는 익명사용자가 요청했을때 처리를 담당한다.
        * SecurityContext 가 null 일경우에 AnonymousAuthenticationToken 을 SecurityContext 에 저장한다.
        * 
        * DefaultLoginPageGeneratingFilter 는 Spring Security 에서 기본으로 제공하는 login 페이지를 설정해준다.
        * http.formLogin().loginPage("/login"); 처럼 Custom 한 login 페이지를 제공할 수 있는데, 
        * 이러한 경우 DefaultLoginPageGeneratingFilter 는 FilterChainProxy 에서 제외 된다. 
        * 또한 DefaultLogoutPageGeneratingFilter 도 제외되며, logout 페이지도 Custom 한 페이지를 제공해야한다.
        * 
        * SessionManagementFilter 는 세션의 검증을 담당한다.
        * 세션 변조 방지 전략 설정을 할 수 있다. 기본설정된 값은 서블릿 버전에 따라 다른데
        * 버전이 3.1 이상일 경우 changeSessionId 를 사용한다.
        * 
        * ExceptionTranslationFilter 는 filters 에서 오류가 발생했을때 처리를 담당한다.
        * AuthorizationFilter 에서 AuthenticationException 과 AccessDeniedException 가 발생했을때 처리를한다.
        * AuthenticationException 는 AuthenticationEntryPoint 를 사용하여 인증이 가능한 페이지로 이동시킨다.
        * AccessDeniedException 는 AccessDeniedHandler 를 사용하여 처리를 담당한다. (403 error 페이지)
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

        http.exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

                    System.out.println(userDetails.getUsername() + " is denied to access " + request.getRequestURI());
                    response.sendRedirect("/access-denied");
                });

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
