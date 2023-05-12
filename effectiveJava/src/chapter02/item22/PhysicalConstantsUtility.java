package chapter02.item22;

/*
* 열거 타입으로 나타내기 적합한 상수라면 열거 타입으로 만들어 공개하면된다.
* 그것도 아니라면, 인스턴스화 할 수 없는 유틸리티 클래스에 담아 공개하자.
* */
public class PhysicalConstantsUtility {
    private PhysicalConstantsUtility() {
    }

    // 아보가드로 수 (1/몰)
    public static final double AVOGADRO_NUMBER = 6.022_140_857e23;

    // 볼츠만 상수 (J/K)
    public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // 전자 질량 (kg)
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}
