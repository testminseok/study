package me.testmain.demospringsecurityform.common;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityLogger {
    public static void log(CharSequence charSequence) {
        System.out.println(charSequence);
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
