package me.testmain.demospringsecurityform.account;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
* Spring Security Config 에 명시적으로 선언해도 되지만
* UserDetailsService 를 구현한 클래스가 Bean 으로 등록이 되어있다면
* 알아서 UserDetailsService 를 구현한 클래스를 사용하여 사용자를 조회한다.
* */
@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username + " is not found");
        }

//        return User.builder()
//                .username(account.getUsername())
//                .password(account.getPassword())
//                .roles(account.getRole())
//                .build();
        return new UserAccount(account);
    }

    public Account createNew(Account account) {
        /*
        * 비밀번호는 약식에 맞게 인코딩유형을 prefix 에 붙여줘야한다.
        * */
        account.setEncodePassword(passwordEncoder);
        return accountRepository.save(account);
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
