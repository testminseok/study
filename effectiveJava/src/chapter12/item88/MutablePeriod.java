package chapter12.item88;

import java.io.*;
import java.util.Date;

// 가변 공격
public class MutablePeriod {
    // Period 인스턴스
    public final Period period;

    // Period 인스턴스의 start 필드
    public final Date start;

    // Period 인스턴스의 end 필드
    public final Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // 유효한 Period 인스턴스를 직렬화한다.
            out.writeObject(new Period(new Date(), new Date()));

            /*
            * 악의적인 '이전 객체 참조', 즉 내부 Date 필드로의 참조를 추가한다.
            * 상세 내용은 자바 객체 직렬화 명세의 6.4절을 참고
            * */
            byte[] ref = {0x71, 0, 0x7e, 0, 5}; // Period 인스턴스의 참조 번호
            bos.write(ref); // 시작 필드
            ref[4] = 4; // 참조 번호 4번으로 변경
            bos.write(ref); // 종료 필드

            // Period 인스턴스를 역직렬화하고 Date 참조를 '훔친다'
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        // 시간을 되돌린다.
        pEnd.setYear(78);
        System.out.println(p);

        // 60년 전으로
        pEnd.setYear(69);
        System.out.println(p);
    }
}
