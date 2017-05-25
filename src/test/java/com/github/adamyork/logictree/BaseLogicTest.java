package com.github.adamyork.logictree;

class BaseLogicTest {

    boolean COND1 = true;
    boolean COND2 = true;
    boolean COND3 = true;
    boolean COND4 = true;
    boolean COND5 = true;
    boolean COND6 = true;

    String runTraditional() {
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

    @SuppressWarnings("ConstantConditions")
    String runTree() {
        final LogicTree tree = new LogicTree();
        final String[] results = {""};
        tree.iff(COND1 && !COND2, o -> results[0] = results[0].concat("branch1-"))
                .thenIff(COND3, o -> results[0] = results[0].concat("branch1.1-"))
                .thenIff(COND4 && !COND5, o -> results[0] = results[0].concat("branch1.1.1-"))
                .thenIff(COND6, o -> results[0] = results[0].concat("branch1.1.1.1-"))
                .end()
                .els(o -> results[0] = results[0].concat("branch1.1.2-"))
                .els(o -> results[0] = results[0].concat("branch1.2-"))
                .els(!COND1 && COND2, o -> results[0] = results[0].concat("branch2-"))
                .evaluate();
        return results[0];
    }
}
