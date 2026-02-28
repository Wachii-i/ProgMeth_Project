package model.rule;

import model.unit.Unit;
import model.core.Position;

public class ManhattanMoveRule implements MoveRule {

    @Override
    public boolean canMove(Unit unit, Position from, Position to) {

        // กัน null
        if (unit == null || from == null || to == null) {
            return false;
        }

        // ยูนิตต้องยังมีชีวิตและยังไม่เดินในเทิร์นนี้
        if (!unit.canMove()) {
            return false;
        }

        // ห้ามเดินอยู่กับที่
        if (from.equals(to)) {
            return false;
        }

        // คำนวณ Manhattan Distance
        int distance = Math.abs(from.getRow() - to.getRow())
                + Math.abs(from.getCol() - to.getCol());

        // เช็คระยะไม่เกิน moveRange
        return distance <= unit.getMoveRange();
    }
}