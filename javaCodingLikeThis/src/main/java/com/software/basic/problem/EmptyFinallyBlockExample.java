package com.software.basic.problem;

import java.sql.*;

/**
 * 7-2 비어있는 finally 블록은 시스템 자원을 낭비할 수 있다.
 * - EmptyControlStatement : 본문이 비어있는 제어문과 빈 초기화 블럭이 있을경우 수정을 권고한다.
 * - EmptyFinallyBlock : 비어있는 finally block 이 있을 경우 수정을 권고한다. (Deprecated - EmptyControlStatement 에 병합됨)
 */
public class EmptyFinallyBlockExample {
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

            // 리소스 해제 - 이 코드에 도달하기 전에 오류가 발생한다면 디비 접속이 정상적으로 되는가
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
