package com.software.design.solution;

import java.sql.*;

/**
 * 9-9 사용한 리소스는 꼭 반환하다.
 * - CloseResource :
 */
public class CloseResources {
    public static void main(String[] args) {
        notBadCode();
        goodCode();
    }

    /**
     * try-with-resources 문을 사용하면 자동으로 리소스를 반환한다.
     * */
    private static void goodCode() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String connectionURL = "database url";
        String query = "select moviename as movieName, releasedate as releaseDate from movies";

        try (Connection con = DriverManager.getConnection(connectionURL);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            // 쿼리 결과 처리
            while (rs.next()) {
                System.out.println("Name = " + rs.getString("movieName") + ", Date = " + rs.getString("releaseDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void notBadCode() {
        String connectionURL = "database url";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 드라이버 로드
            Class.forName("org.postgresql.Driver");

            // 연결 생성
            con = DriverManager.getConnection(connectionURL);

            // 쿼리 실행 클래스 생성
            stmt = con.createStatement();

            // 쿼리 실행 후 결과 반환
            rs = stmt.executeQuery("select moviename as movieName, releasedate as releaseDate from movies");

            // 쿼리 결과 처리
            while (rs.next()) {
                System.out.println("Name = " + rs.getString("movieName") + ", Date = " + rs.getString("releaseDate"));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
