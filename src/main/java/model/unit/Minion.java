package model.unit;

import model.core.Position;
import model.core.Team;

public abstract class Minion extends Unit {
    public Minion(String id, Team team, Position position, int moveRange, int hp, int attackPower, int attackRange) {
        super(id, team, position, moveRange, hp, attackPower, attackRange);
    }
}