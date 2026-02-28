package model.rule;

import model.unit.Unit;
import model.core.Position;

public interface MoveRule {
    boolean canMove(Unit unit, Position from, Position to);
}