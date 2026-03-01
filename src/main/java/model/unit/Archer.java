package model.unit;

import model.core.Position;
import model.core.Team;

public class Archer extends Minion {

    public Archer(String id, Team team, Position position) {
        super(id, team, position,2, 8, 2, 4);
        this.name = "Archer";
    }

    @Override
    public int computeDamage(Unit target) {
        return this.attackPower; // หรือ return getAttackPower(); ถ้ามึงทำ getter
    }
}