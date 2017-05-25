package com.github.adamyork.logictree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTreeTestFour extends BaseLogicTest {

    @Before
    public void setup() {
        COND1 = true;
        COND2 = false;
        COND3 = true;
        COND4 = true;
        COND5 = true;
        COND6 = true;
    }

    @Test
    public void testTraditionalResultsMatchTreeResults() {
        final String traditional = runTraditional();
        final String tree = runTree();
        assertEquals(traditional, tree);
    }

}
