package com.software.design.problem;

import java.sql.*;

/**
 * 9-9 사용한 리소스는 꼭 반환하다.
 * - CloseResource : 리소스가 사용 후 닫혀 있느지 확인하고 닫히지 않았다면 수정을 권고한다.
 *                   AutoCloseable 인터페이스를 구현한 클래스는 try-with-resources 문을 사용해 자동으로 닫히도록 할 수 있다.
 */
public class CloseResources {
    public static void main(String[] args) {
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
        }
    }
}
