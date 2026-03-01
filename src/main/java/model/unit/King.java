package model.unit;

import model.core.Position;
import model.core.Team;

public class King extends Unit {

    public King(String id, Team team, Position position) {
        super(id, team, position, 1, 100, 20, 1);
    }

    @Override
    public int computeDamage(Unit target) {
        return getAttackPower();
    }
}