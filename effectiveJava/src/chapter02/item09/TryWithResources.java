package chapter02.item09;

import java.io.*;

public class TryWithResources {

    // try-finally - 더 이상 자원을 회수하는 최선의 방책이 아니다!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-finally - 자원이 둘 이상이면 try-finally 방식은 너무 지저분하다!
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // 1바이트씩 읽어서 쓴다.
                byte[] buf = new byte[1024];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try-with-resources - 자원을 회수하는 최선책!
    static String firstLineOfFile2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // 복수의 자원을 처리하는 try-with-resources - 짧고 매혹적이다!
    static void copy2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            // 1바이트씩 읽어서 쓴다.
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
