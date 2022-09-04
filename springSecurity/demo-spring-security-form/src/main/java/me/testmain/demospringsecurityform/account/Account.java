package me.testmain.demospringsecurityform.account;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEncodePassword(PasswordEncoder passwordEncoder) {
        /*
        * Spring Security 5.x 이전 버전에서는 NoOpPasswordEncoder 를 기본으로 사용하였지만,
        * 이후 기본 인코딩 타입이 bcrypt 로 바뀌고 다양한 인코딩을 지원하기 위해 바뀌었다.
        * */
        password = passwordEncoder.encode(password);
    }
}
