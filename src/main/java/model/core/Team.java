package model.core;

public enum Team {
    RED,
    BLUE;

    public Team opposite() {
        return this == RED ? BLUE : RED;
    }
}
