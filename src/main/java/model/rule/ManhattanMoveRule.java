package model.rule;

import model.unit.Unit;
import model.core.Position;

public class ManhattanMoveRule implements MoveRule {

    @Override
    public boolean canMove(Unit unit, Position from, Position to) {

        if (unit == null || from == null || to == null) return false;

        // กัน desync (แนะนำมาก)
        if (!from.equals(unit.getPosition())) return false;

        if (!unit.canMove()) return false;

        if (from.equals(to)) return false;

        return unit.distanceTo(to) <= unit.getMoveRange();
    }
}