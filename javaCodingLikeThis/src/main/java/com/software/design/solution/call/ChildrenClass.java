package com.software.design.solution.call;

public class ChildrenClass extends ParentClass {
    private String name;

    public ChildrenClass(String name) {
        super();
        this.name = name;
    }

    @Override
    protected void print() {
        System.out.println(toString());
    }
}
