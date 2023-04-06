package com.software.basic.problem.debug;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IDGeneratorJUnit4Test {

    private static IDGenerator idGenerator;

    @Before
    public void setUp() throws Exception {
        idGenerator = new IDGenerator(0);
    }

    @Test
    public void generateId() {
        assertEquals(0, idGenerator.newId());
        assertEquals(1, idGenerator.newId());
        assertEquals(2, idGenerator.newId());
    }

    @Test
    public void generateId2() {
        assertEquals(0, idGenerator.newId());
        assertEquals(1, idGenerator.newId());
        assertEquals(2, idGenerator.newId());
    }
}