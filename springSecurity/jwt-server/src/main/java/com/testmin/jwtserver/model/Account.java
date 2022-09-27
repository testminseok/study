package com.testmin.jwtserver.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
public class Account {

    @Id @GeneratedValue
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String roles;

    public Account() {}

    @Builder
    public Account(long id, String username, String password, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return Arrays.stream(roles.split(",")).toList();
    }
}
