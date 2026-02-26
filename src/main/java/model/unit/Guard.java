package model.unit;

import model.core.Position;
import model.core.Team;

public class Guard extends Minion {
    public Guard(String id, Team team, Position position) {
        super(id, team, position, 1, 15, 1, 1);
        this.name = "Guard";
    }
    @Override
    public int computeDamage(Unit target) { return this.attackPower; }
}
