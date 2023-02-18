package com.software.basic.problem.string;

/**
 * 4-1 중복된 물자열은 제거한다.
 * - AvoidDuplicateLiterals : 중복된 문자열을 포함하는 코드는 문자열을 상수 필드로 선언하여 개선하기를 권고한다.
 */
public class DuplicatedLiteralsExample {

    private String userId;
    private String password;
    private String role;

    public String getRoleName(final String role) {
        if ("R01".equals(role)) {
            return "admin";
        }

        if ("R02".equals(role)) {
            return "user";
        }

        return "empty";
    }

    public boolean changeRole(final String role) {
        if ("R01".equals(role) || "R02".equals(role)) {
            return false;
        }

        this.role = role;
        return true;
    }

    public void createUser(final String userId, final String password) {
        String defaultRole = "R02";

        if ("admin".equals(userId)) {
            defaultRole = "R01";
        }

        this.userId = userId;
        this.password = password;
        this.role = defaultRole;
    }

    public boolean updateUser(final String userId, final String password, final String role) {
        if ("R01".equals(role) || "R02".equals(role)) {
            return false;
        }

        this.userId = userId;
        this.password = password;
        this.role = role;
        return true;
    }
}
