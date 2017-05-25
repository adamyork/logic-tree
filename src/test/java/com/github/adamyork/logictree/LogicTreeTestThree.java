package com.github.adamyork.logictree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTreeTestThree extends BaseLogicTest {

    @Before
    public void setup() {
        COND1 = true;
        COND2 = false;
        COND3 = false;
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
