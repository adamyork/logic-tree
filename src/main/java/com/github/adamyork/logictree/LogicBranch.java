package com.github.adamyork.logictree;

import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public class LogicBranch implements Consumer<Object> {

    private boolean condition;
    private List<Consumer<Object>> left;
    private List<Consumer<Object>> right;
    private String name;

    public LogicBranch(final boolean condition,
                       final List<Consumer<Object>> left,
                       final List<Consumer<Object>> right) {
        this.condition = condition;
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(final Object o) {
        if (condition) {
            iterate(left);
        } else {
            if (right == null) {
                return;
            }
            iterate(right);
        }
    }

    @Override
    public Consumer<Object> andThen(final Consumer<? super Object> after) {
        return null;
    }

    public List<Consumer<Object>> getLeft() {
        return left;
    }

    public void setRight(final List<Consumer<Object>> right) {
        this.right = right;
    }

    public void setName(final String name) {
        this.name = name;
    }

    private void iterate(final List<Consumer<Object>> side) {
        side.forEach(objectConsumer -> objectConsumer.accept(null));
    }
}