package me.testmain.demospringsecurityform.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    public void dashboard() {
        /*
        * SecurityContextHolder 에 사용자 인증 정보가 담겨있는 Authentication 객체를 가져올 수 있다.
        * 기본적으로 ThreadLocal 을 사용한다.
        * principal 객체는 User 타입이다.
        * authorities 안에는 사용자 권한이 담겨있고, ROLE_권한이름 의 형태로 담겨있다.
        * isAuthenticated 는 토큰 만료 같은 경우가 아니면 logout 하기 전까지 true 이다.
        * */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        boolean authenticated = authentication.isAuthenticated();
    }
}
