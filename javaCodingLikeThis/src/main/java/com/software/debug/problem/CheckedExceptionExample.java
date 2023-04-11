package com.software.debug.problem;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 13-2 통합된 예외 처리가 아닌 각 예외의 유형에 맞게 처리해야 한다.
 * - AvoidCatchingThrowable : Throwable 을 catch 하는경우 수정을 권고한다.
 * - AvoidCatchingGenericException : NullPointerException, RuntimeException, Exception 등을 catch 하는 경우 수정을 권고한다.
 * - DoNotExtendJavaLangError : Error 를 상속받는 경우 수정을 권고한다.
 * - AvoidThrowingRawExceptionTypes : 예외 객체를 최상위 객체로 처리하는 경우 수정을 권고한다.
 * - AvoidThrowingNullPointerException : NullPointerException 을 발생시키는 경우 수정을 권고한다.
 *                                       대부분의 프로그래머가 NullPointerException 이 발생하는 경우 JVM 이 throw 했다고 생각하기 떄문에
 *                                       혼란을 야기 할 수 있다. 그러므로 IllegalArgumentException 를 대신 사용하여
 *                                       프로그래머가 throw 했다는 것을 명확하게 한다.
 */
public class CheckedExceptionExample extends Error {
    public static void main(String[] args) {
        CheckedExceptionExample example = new CheckedExceptionExample();
        String result;
        result = example.loadWebPage("http://www.google.com", "d:\\web1.txt");
        System.out.println(result);

        result = example.loadWebPage("http://www.google.com", "d:\\web2.txt");
        System.out.println(result);

        result = example.loadWebPage("http://www.google.com", "d:\\web2.txt");
        System.out.println(result);

        result = example.loadWebPage("http://www.google.com", null);
        System.out.println(result);
    }

    private String loadWebPage(String urlString, String filename) {
        String result = "success";
        URL url;
        try {
            url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            File file = new File(filename);

            // 파일이 존재하지 않으면 파일 생성
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            while ((line = reader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            reader.close();
            bufferedWriter.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            result = "fail";
            // 가장 잘못된 예외 처리 화면에만 문제가 표시되고
            // 어디에도 문제점이 기록되지 않아 문제가 숨겨진다.
            e.printStackTrace();
        }
        return result;
    }
}
