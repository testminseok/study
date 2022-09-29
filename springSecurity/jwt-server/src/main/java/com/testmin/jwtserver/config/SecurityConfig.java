package com.testmin.jwtserver.config;

import com.testmin.jwtserver.filter.CustomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    private final CorsFilter corsFilter;

    public SecurityConfig(CorsFilter corsFilter) {
        this.corsFilter = corsFilter;
    }

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.addFilterBefore(new CustomFilter(), WebAsyncManagerIntegrationFilter.class);
        http.addFilter(corsFilter);

        /*
        * 서버에서 Csrf token 을 사용하지 않음을 설정
        * */
        http.csrf(httpSecurityCsrfConfigurer -> {
            httpSecurityCsrfConfigurer.disable();
        });

        /*
        * 서버에서 세션을 사용하지 않음을 설정
        * */
        http.sessionManagement(httpSecuritySessionManagementConfigurer -> {
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        /*
        * 서버에서 formLogin 을 통한 인증을 사용하지 않음을 설정
        * */
        http.formLogin(httpSecurityFormLoginConfigurer -> {
           httpSecurityFormLoginConfigurer.disable();
        });

        /*
        * 서버에서 Authorization Basic 을 통한 인증을 사용하지 않음을 설정
        * */
        http.httpBasic(httpSecurityHttpBasicConfigurer -> {
            httpSecurityHttpBasicConfigurer.disable();
        });

        /*
        * 요청에 필요한 권한 설정
        * */
        http.authorizeRequests(registry -> {
            registry.mvcMatchers("/api/v1/account/**").hasAnyRole("USER", "MANAGER", "ADMIN");
            registry.mvcMatchers("/api/v1/manager/**").hasAnyRole("MANAGER", "ADMIN");
            registry.mvcMatchers("/api/v1/admin/**").hasRole("ADMIN");
            registry.anyRequest().permitAll();
        });

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return authentication -> {
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
        };
    }
}
