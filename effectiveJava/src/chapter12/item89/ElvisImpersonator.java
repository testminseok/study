package chapter12.item89;

import chapter12.util.SerializationHelper;

public class ElvisImpersonator {
    // 진짜 Elvis 인스턴스로는 만들어 질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
            -84, -19, 0, 5, 115, 114, 0, 22, 99, 104, 97, 112,
            116, 101, 114, 49, 50, 46, 105, 116, 101, 109, 56,
            57, 46, 69, 108, 118, 105, 115, 71, 71, -96, -18, 4,
            -37, 100, -107, 2, 0, 1, 91, 0, 13, 102, 97, 118, 111,
            114, 105, 116, 101, 83, 111, 110, 103, 115, 116, 0, 19,
            91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83,
            116, 114, 105, 110, 103, 59, 120, 112, 117, 114, 0, 19, 91,
            76, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116, 114,
            105, 110, 103, 59, -83, -46, 86, -25, -23, 29, 123, 71, 2, 0, 0,
            120, 112, 0, 0, 0, 1, 116, 0, 16, 65, 32, 70, 111, 111, 108, 32, 83,
            117, 99, 104, 32, 97, 115, 32, 73
    };

    public static void main(String[] args) {
        // ElvisStealer.impersonator 를 초기화 한다음
        // 진짜 Elvis 를 반환한다.
        Elvis elvis = (Elvis) SerializationHelper.deserialize(serializedForm);
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }
}
