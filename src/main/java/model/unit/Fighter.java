package model.unit;

import model.core.Position;
import model.core.Team;

public class Fighter extends Minion {
    public Fighter(String id, Team team, Position position) {
        super(id, team, position, 2, 12, 2, 1);
        this.name = "Fighter";
    }
    @Override
    public int computeDamage(Unit target) { return this.attackPower; }
}