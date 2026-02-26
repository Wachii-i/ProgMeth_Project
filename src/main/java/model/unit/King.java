package model.unit;

import model.core.Position;
import model.core.Team;

public class King extends Unit {

    //Constructor
    public King(String id, Team team, Position position) {
        super(id, team, position, 1, 20, 2, 1);
        this.name = "King";
    }
    //Method
    @Override
    public int computeDamage(Unit target) { return this.attackPower; }
}
