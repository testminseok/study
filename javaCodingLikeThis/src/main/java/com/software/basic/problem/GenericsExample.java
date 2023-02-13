package com.software.basic.problem;

/**
 * - GenericsNaming : 제네릭의 이름은 단일 대문자로 제한한다.
 * */
public class GenericsExample<Template> {
    private Template templateValue;

    public Template get() {
        return this.templateValue;
    }

    public void set(Template template) {
        this.templateValue = template;
    }

    public static void main(String[] args) {
        GenericsExample<String> type = new GenericsExample<>();
        type.set("Test"); // 허용

        GenericsExample type1 = new GenericsExample();
        type1.set("test"); // 허용
        type1.set(10); // 오토박싱지원

        System.out.println(type1.get());

    }
}
