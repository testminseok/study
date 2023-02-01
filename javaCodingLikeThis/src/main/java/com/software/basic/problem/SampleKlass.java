package com.software.basic.problem;

import java.util.Objects;

/**
 * 1-15 equals 와 hashcode 메소드는 언제나 함께 오버라이드한다.
 * - OverrideBothEqualsAndHashCode : Equals 와 hashCode 메소드 중 어느 할쪽만을 오버라이드할 경우 수정을 권하는 규칙
 */
public class SampleKlass {
    int id;
    String name;

    public SampleKlass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleKlass that = (SampleKlass) o;
        return id == that.id && Objects.equals(name, that.name);
    }

}
