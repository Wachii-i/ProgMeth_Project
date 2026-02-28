package model.board;

import model.core.Position;
import model.unit.Unit;

public class Cell {

    private final Position position;
    private Unit occupant;  // null = ช่องว่าง

    public Cell(Position position) {
        this.position = position;
        this.occupant = null;
    }

    // ===== Basic Info =====

    public Position getPosition() {
        return position;
    }

    public Unit getOccupant() {
        return occupant;
    }

    public boolean isEmpty() {
        return occupant == null;
    }

    // ===== Control Unit =====

    public void placeUnit(Unit unit) {
        if (!isEmpty()) {
            throw new IllegalStateException("Cell is already occupied");
        }
        this.occupant = unit;
    }

    public void removeUnit() {
        this.occupant = null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Cell" + position + " [EMPTY]";
        }
        return "Cell" + position + " [Unit=" + occupant.getId() + "]";
    }
}