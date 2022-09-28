package com.testmin.jwtserver.config;

import com.testmin.jwtserver.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {

//    @Bean
    FilterRegistrationBean<CustomFilter> customFilterFilterRegistrationBean() {
        /*
        * SecurityFilterChain 의 filter 가 전부 종료된 이후 order 순서대로 실행된다.
        * SecurityFilterChain 보다 먼저 실행하거나, 중간에 넣고 싶을땐 addFilterBefore 를 통해 등록한다.
        * */
        FilterRegistrationBean<CustomFilter> bean = new FilterRegistrationBean<>(new CustomFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }
}
