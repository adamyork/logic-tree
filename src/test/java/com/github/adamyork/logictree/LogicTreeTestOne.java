package com.github.adamyork.logictree;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class LogicTreeTestOne {
    
    private static final boolean COND1 = true;
    private static final boolean COND2 = false;
    private static final boolean COND3 = true;
    private static final boolean COND4 = true;
    private static final boolean COND5 = false;
    private static final boolean COND6 = true;
    
    @Test
    public void testTraditionalResultsMatchTreeResults(){
        final String traditional = runTraditional();
        final String tree = runTree();
        assertEquals(traditional,tree);
    }
    
    private String runTraditional(){
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
    
    private String runTree(){
        LogicTreeTestHandlers.setResults("");
        final LogicTree tree = new LogicTree();
        tree.iff(COND1 && !COND2, LogicTreeTestHandlers.getHandler1())
            .thenIff(COND3, LogicTreeTestHandlers.getHandler1_1())
            .thenIff(COND4 && !COND5, LogicTreeTestHandlers.getHandler1_1_1())
            .thenIff(COND6, LogicTreeTestHandlers.getHandler1_1_1_1())
            .end()
            .els(LogicTreeTestHandlers.getHandler1_1_2())
            .els(LogicTreeTestHandlers.getHandler1_2())
            .els(!COND1 && COND2,LogicTreeTestHandlers.getHandler2())
            .evaluate();
        return LogicTreeTestHandlers.getResults();
    }

}
