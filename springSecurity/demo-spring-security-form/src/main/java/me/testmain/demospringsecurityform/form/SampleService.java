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
        *
        * Authentication 객체가 SecurityContextHolder.getContext().getAuthentication() 에 담기기 까지의 과정
        * 실제로 인증은 AuthenticationManager 라는 인터페이스가 담당하게 되는데
        * 이것을 구현한 ProviderManager.authenticate(Authentication authentication) 메소드에서 인증과정을 진행한다.
        * 그 중 form 로그인을 인증할 수 있는 DaoAuthenticationProvider 클래스의 retrieveUser() 메소드로 사용자를 조회하게 되는데
        * 이때 개발자가 UserDetailService 를 구현하여 Bean 으로 등록된 객체를 사용하여 사용자를 조회한다.
        * 조회한 후 사용자의 계정이 잠겼는지, 비활성화 되었는지, 만료되었는지 검증한 후 사용자정보가 들어있는 Authentication 객체를 반환한다.
        * */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        boolean authenticated = authentication.isAuthenticated();
    }
}
