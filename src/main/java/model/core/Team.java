package model.core;

public enum Team {
    TEAM_1,
    TEAM_2;

    public Team opposite() {
        return this == TEAM_1 ? TEAM_2 : TEAM_1;
    }
}
