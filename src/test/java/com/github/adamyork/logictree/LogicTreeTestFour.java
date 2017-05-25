package com.github.adamyork.logictree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class LogicTreeTestFour {

    private static final boolean COND1 = true;
    private static final boolean COND2 = false;
    private static final boolean COND3 = true;
    private static final boolean COND4 = true;
    private static final boolean COND5 = true;
    private static final boolean COND6 = true;

    @Test
    public void testTraditionalResultsMatchTreeResults() {
        final String traditional = runTraditional();
        final String tree = runTree();
        assertEquals(traditional, tree);
    }

    @SuppressWarnings("Duplicates")
    private String runTraditional() {
        String results = "";
        if (COND1 && !COND2) {
            results += "branch1-";
            if (COND3) {
                results += "branch1.1-";
                if (COND4 && !COND5) {
                    results += "branch1.1.1-";
                    if (COND6) {
                        results += "branch1.1.1.1-";
                    }
                } else {
                    results += "branch1.1.2-";
                }
            } else {
                results += "branch1.2-";
            }
        } else if (!COND1 && COND2) {
            results += "branch2-";
        }
        return results;
    }

    @SuppressWarnings({"ConstantConditions", "Duplicates"})
    private String runTree() {
        final LogicTree tree = new LogicTree();
        final String[] results = {""};
        tree.iff(COND1 && !COND2, o -> {
            results[0] = results[0].concat("branch1-");
            return null;
        }).thenIff(COND3, o -> {
            results[0] = results[0].concat("branch1.1-");
            return null;
        }).thenIff(COND4 && !COND5, o -> {
            results[0] = results[0].concat("branch1.1.1-");
            return null;
        }).thenIff(COND6, o -> {
            results[0] = results[0].concat("branch1.1.1.1-");
            return null;
        }).end().els(o -> {
            results[0] = results[0].concat("branch1.1.2-");
            return null;
        }).els(o -> {
            results[0] = results[0].concat("branch1.2-");
            return null;
        }).els(!COND1 && COND2, o -> {
            results[0] = results[0].concat("branch2-");
            return null;
        }).evaluate();
        return results[0];
    }

}
