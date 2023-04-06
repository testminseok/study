package com.software.basic.problem.debug;

public class IDGenerator {
    private int currentId;

    public IDGenerator(int currentId) {
        this.currentId = currentId;
    }

    public int newId() {
        return currentId++;
    }
}
