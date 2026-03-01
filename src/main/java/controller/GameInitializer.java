package controller;

import model.board.Board;
import model.core.Position;
import model.core.Team;
import model.unit.Archer;
import model.unit.Fighter;
import model.unit.Guard;
import model.unit.King;
import model.unit.Unit;

public class GameInitializer {

    private final Board board;

    public GameInitializer(Board board) {
        if (board == null) throw new IllegalArgumentException("board cannot be null");
        this.board = board;
    }

    /**
     * ตั้งค่าเริ่มเกม:
     * - วางยูนิตของทั้ง 2 ทีมลงบนบอร์ด
     * - RED อยู่ฝั่งซ้าย, BLUE อยู่ฝั่งขวา
     *
     * Layout (แถวกลางของบอร์ด):
     *   RED:  Guard / King / Archer / Fighter (กระจายรอบ ๆ คอลัมน์ซ้าย)
     *   BLUE: Guard / King / Archer / Fighter (กระจายรอบ ๆ คอลัมน์ขวา)
     */
    public void initialize() {
        int rows = board.getRows();
        int cols = board.getCols();

        if (rows < 3 || cols < 2) {
            throw new IllegalStateException("board is too small for initial placement");
        }

        int midRow = rows / 2;

        // =============================
        // RED TEAM (ฝั่งซ้าย)
        // =============================
        placeSafe(new King("R-KING", Team.RED, new Position(midRow, 0)));
        placeSafe(new Guard("R-GUARD", Team.RED, new Position(midRow - 1, 0)));
        placeSafe(new Archer("R-ARCHER", Team.RED, new Position(midRow + 1, 0)));
        placeSafe(new Fighter("R-FIGHTER", Team.RED, new Position(midRow, 1))); // ขยับเข้ามา 1 ช่อง กันทับ

        // =============================
        // BLUE TEAM (ฝั่งขวา)
        // =============================
        placeSafe(new King("B-KING", Team.BLUE, new Position(midRow, cols - 1)));
        placeSafe(new Guard("B-GUARD", Team.BLUE, new Position(midRow - 1, cols - 1)));
        placeSafe(new Archer("B-ARCHER", Team.BLUE, new Position(midRow + 1, cols - 1)));
        placeSafe(new Fighter("B-FIGHTER", Team.BLUE, new Position(midRow, cols - 2))); // ขยับเข้ามา 1 ช่อง กันทับ
    }

    // -----------------------------
    // Helper: วางยูนิตแบบปลอดภัย
    // -----------------------------
    private void placeSafe(Unit unit) {
        Position pos = unit.getPosition();

        if (!board.isInside(pos)) {
            throw new IllegalStateException("Initial position out of board: " + unit.getId() + " at " + pos);
        }
        if (!board.isEmpty(pos)) {
            throw new IllegalStateException("Initial position occupied: " + unit.getId() + " at " + pos);
        }

        board.placeUnit(unit, pos); // จะ sync unit.setPosition(pos) อยู่แล้ว
    }
}