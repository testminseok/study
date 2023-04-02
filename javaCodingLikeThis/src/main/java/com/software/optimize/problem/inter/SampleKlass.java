package com.software.optimize.problem.inter;

public class SampleKlass implements SampleInterface {

    @Override
    public void printValue() {
        System.out.println(value);
    }

    @Override
    public void printStr() {
        System.out.println(str);
    }

    public static void main(String[] args) {
        SampleKlass sampleKlass = new SampleKlass();
        sampleKlass.printValue();
        sampleKlass.printStr();

        System.out.println(sampleKlass.value);
        System.out.println(sampleKlass.str);
    }
}
