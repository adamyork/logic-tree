package com.github.adamyork.logictree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTreeTestTwo extends BaseLogicTest {

    @Before
    public void setup() {
        COND1 = false;
        COND2 = true;
        COND3 = true;
        COND4 = true;
        COND5 = false;
        COND6 = true;
    }

    @Test
    public void testTraditionalResultsMatchTreeResults() {
        final String traditional = runTraditional();
        final String tree = runTree();
        assertEquals(traditional, tree);
    }

}
