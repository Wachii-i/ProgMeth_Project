package model.unit;

import model.core.Position;
import model.core.Team;

public abstract class Unit {

    //Fields
    private final String id;
    private final Team team;            //core.Team(ENUM)
    protected String name;
    protected int moveRange;
    protected int hp;
    protected int attackRange;
    protected int attackPower;
    private boolean movedThisTurn;
    private boolean attackedThisTurn;
    private Position position;   //core.Position

    //Constructor
    public Unit(String id, Team team, Position position,int moveRange, int hp, int attackPower, int attackRange) {
        this.id = id;
        this.team = team;
        this.position = position;
        this.hp = hp;
        this.moveRange = moveRange;
        this.attackRange = attackRange;
        this.attackPower = attackPower;
        this.movedThisTurn = false;
        this.attackedThisTurn = false;
    }
    //Method
    public final void setPosition(Position newPos) {
        if (newPos == null) throw new IllegalArgumentException("position cannot be null");
        this.position = newPos;
    }

    public final void markMoved() {
        if (!isAlive()) return;
        this.movedThisTurn = true;
    }

    public abstract int computeDamage(Unit target);

    public boolean isAlive() { return hp > 0; }

    public void takeDamage(int dmg) {
        this.hp = Math.max(0, this.hp - dmg);
    }

    public int distanceTo(Position other) {
        return Math.abs(position.getRow() - other.getRow())
                + Math.abs(position.getCol() - other.getCol());
    }

    //Getter & Setter
    public Team getTeam() { return team; }
    public String getId() { return id; }
    public Position getPosition() { return position; }
    public boolean canMove() { return !movedThisTurn && isAlive();}
    public boolean canAttack() { return !attackedThisTurn && isAlive(); }
    public void markAttacked() { this.attackedThisTurn = true; }
    public void resetTurnFlags() {
        this.movedThisTurn = false;
        this.attackedThisTurn = false;
    }
    public int getMoveRange() { return moveRange; }
    public int getAttackRange() { return attackRange; }
    public int getAttackPower() { return attackPower; }
    public int getHp() { return hp; }
    public String getName() { return name; }

}
