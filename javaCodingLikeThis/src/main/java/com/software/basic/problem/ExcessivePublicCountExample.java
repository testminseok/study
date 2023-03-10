package com.software.basic.problem;

/**
 * 8-4 클래스의 결합도는 낮춰야 한다.
 * - ExcessivePublicCount : public 메소드 및 public class member 가 45개 이상일 경우 수정을 권고한다.
 *                          public 접근제어자가 많은 경우 겹합 부작용이 빠르게 증가하며 위험성이 증가하고 테스트가 힘들다
 *                          때문에 이 클래스에 멤버변수들을 작은 클래스로 리팩터링 함으로써 테스트 가능성과 신뢰성이 향상될 뿐만아니라
 *                          새로운 변형을 쉽게 할수 있게 된다.
 *                          또한 해결 방안을 적용한다고 무작정 해당 룰에 따라 단순히 public 으로 공개된 메소드를 줄여선 절대로 안된다.
 *                          PMD 경고 메세지를 피하기 위한 임시방편일 뿐 오히려 소프트웨어의 품질을 악화시킬 수 있다.
 *                          예를 들어 String 클래스는 public 공개된 수십 개의 메소드를 제공하지만 문자열 관리를 위한 기능으로만
 *                          구성되어 있어 높은 응집도와 낮은 결합도를 유지하고 있다.
 *                          그로므로 단순히 외부에서 접근 가능한 메소드가 몇 개나 존재하는가가 아니라 적정한 응집도와 결홥도를
 *                          유지하는 것이 가장 올바른 해결법이다.
 */
public class ExcessivePublicCountExample {
    public String value;
    public int something;
    public double var;
    public double var1;
    public double var2;
    public double var3;
    public double var4;
    public double var5;
    public double var6;
    public double var7;
    public double var8;
    public double var9;
    public double var10;
    public double var11;
    public double var12;
    public double var13;
    public double var14;

    // ...

    public void doWork() {

    }

    public void doMoreWork() {

    }

    public void doWorkAgain() {

    }

    // ...
}
