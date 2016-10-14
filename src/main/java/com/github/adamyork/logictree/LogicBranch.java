package com.github.adamyork.logictree;

import java.util.List;
import java.util.function.Function;

class LogicBranch implements Function<Object,Void>{
    
    private boolean condition;
    private List<Function<Object,Void>> left;
    private List<Function<Object,Void>> right;
    private String name;

    public LogicBranch(final boolean condition, 
            final List<Function<Object,Void>>left, 
            final List<Function<Object,Void>> right) {
        this.condition = condition;
        this.left = left;
        this.right = right;
    }
    
    public void evaluate() {
        if (condition) {
           iterate(left);
        } else {
            if (right == null) {
                return;
            }
            iterate(right);
        }
    }
   
    public List<Function<Object,Void>> getLeft() {
        return left;
    }
    
    public void setRight(final List<Function<Object,Void>> right) {
        this.right = right;
    }
    
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    private void iterate(final List<Function<Object,Void>> side) {
        for (int i = 0; i < side.size(); i++) {
            final Function<Object,Void> func = side.get(i);
            if (func instanceof LogicBranch) {
                final LogicBranch branch = (LogicBranch) func;
                branch.evaluate();
            } else {
                func.apply(null);
            }
        }
    }

    @Override
    public Void apply(Object t) {
        return null;
    }
}