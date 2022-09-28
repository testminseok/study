package com.testmin.jwtserver.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        /*
        * Token 값을 검증한 후 testmin 이라면, 로그인 된 사용자로 접근 허가
        * 검증 (RSA, HS256)
        * */
        if (HttpMethod.POST.matches(req.getMethod())) {
            String authorization = req.getHeader(HttpHeaders.AUTHORIZATION);
            System.out.println(authorization);

            if (authorization.equals("testmin")) {
                chain.doFilter(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("인증이 안됨");
                out.flush();
                out.close();
            }
        }
    }
}
