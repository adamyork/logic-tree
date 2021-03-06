package com.github.adamyork.logictree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public class LogicTree {

    private List<LogicBranch> branches;
    private int terminated;
    private int handled;

    public LogicTree() {
        this.branches = new ArrayList<>();
        this.terminated = 0;
        this.handled = 0;
    }

    public LogicTree iff(final boolean condition,
                         final Consumer<Object> handler) {
        final List<Consumer<Object>> handlers = new ArrayList<>();
        handlers.add(handler);
        final LogicBranch branch = new LogicBranch(condition, handlers, null);
        branch.setName("branch " + this.branches.size());
        branches.add(branch);
        return this;
    }

    public LogicTree thenIff(final boolean condition,
                             final Consumer<Object> handler) {
        final List<Consumer<Object>> handlers = new ArrayList<>();
        handlers.add(handler);
        final LogicBranch branch = new LogicBranch(condition, handlers, null);
        branch.setName("branch " + branches.size());
        final LogicBranch last = branches.get(branches.size() - 1);
        final List<Consumer<Object>> left = last.getLeft();
        left.add(1, branch);
        branches.add(branch);
        return this;
    }

    public LogicTree els(final Consumer<Object> handler) {
        final int index = (branches.size() - 1) - terminated - handled;
        final LogicBranch b = branches.get(index);
        final List<Consumer<Object>> handlers = new ArrayList<>();
        handlers.add(handler);
        b.setRight(handlers);
        this.handled++;
        return this;
    }

    public LogicTree els(final boolean condition,
                         final Consumer<Object> handler) {
        final int index = (branches.size() - 1) - terminated - handled;
        final List<Consumer<Object>> handlers = new ArrayList<>();
        handlers.add(handler);
        final LogicBranch branch = new LogicBranch(condition, handlers, null);
        branch.setName("branch " + branches.size());
        branches.add(branch);
        final List<Consumer<Object>> right = new ArrayList<>();
        right.add(branch);
        final LogicBranch branchAtIndex = this.branches.get(index);
        branchAtIndex.setRight(right);
        this.handled++;
        return this;
    }

    public LogicTree end() {
        this.terminated++;
        return this;
    }

    public void evaluate() {
        this.branches.get(0).accept(null);
    }

}