package model.board;

import model.core.Position;
import model.unit.Unit;

public class Board {

    private final int rows;
    private final int cols;
    private final Cell[][] grid;

    public Board(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and cols must be positive");
        }
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];

        // สร้าง Cell ทุกช่องในกระดาน
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell(new Position(r, c));
            }
        }
    }

    // ===== Basic Info =====

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    // ===== Bound Check =====

    public boolean isInside(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    // ===== Access Cell =====

    public Cell getCell(Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("Position out of board: " + pos);
        }
        return grid[pos.getRow()][pos.getCol()];
    }

    public boolean isEmpty(Position pos) {
        return getCell(pos).isEmpty();
    }

    public Unit getUnitAt(Position pos) {
        return getCell(pos).getOccupant(); // ถ้าว่างจะได้ null
    }

    // ===== Place / Remove / Move =====

    /** วางยูนิตลงช่องที่กำหนด (ใช้ตอนเริ่มเกม) */
    public void placeUnit(Unit unit, Position pos) {
        if (unit == null) throw new IllegalArgumentException("unit cannot be null");
        Cell cell = getCell(pos);
        cell.placeUnit(unit);
    }

    /** ลบยูนิตออกจากช่อง (เช่น ตอนตาย) */
    public void removeUnit(Position pos) {
        Cell cell = getCell(pos);
        cell.removeUnit();
    }

    /**
     * ย้ายยูนิตจาก from -> to
     * - ต้องอยู่ในบอร์ดทั้งคู่
     * - ช่อง from ต้องมี unit
     * - ช่อง to ต้องว่าง
     */
    public void moveUnit(Position from, Position to) {
        if (!isInside(from) || !isInside(to)) {
            throw new IllegalArgumentException("from/to out of board");
        }

        Cell fromCell = getCell(from);
        Cell toCell = getCell(to);

        if (fromCell.isEmpty()) {
            throw new IllegalStateException("No unit at from position: " + from);
        }
        if (!toCell.isEmpty()) {
            throw new IllegalStateException("Target cell is occupied: " + to);
        }

        Unit unit = fromCell.getOccupant();
        fromCell.removeUnit();
        toCell.placeUnit(unit);
    }
}