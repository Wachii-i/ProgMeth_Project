package util;

import model.core.Position;

public final class GridMath {

    // ป้องกันการ new class นี้
    private GridMath() {}

    // ======================================
    // Manhattan Distance
    // ======================================

    /**
     * คำนวณ Manhattan distance ระหว่าง 2 จุด
     */
    public static int manhattan(Position a, Position b) {
        return Math.abs(a.getRow() - b.getRow())
                + Math.abs(a.getCol() - b.getCol());
    }

    /**
     * เช็คว่าระยะ Manhattan อยู่ใน range ไหม
     */
    public static boolean withinRange(Position from, Position to, int range) {
        return manhattan(from, to) <= range;
    }

    // ======================================
    // Direction
    // ======================================

    /**
     * เช็คว่าอยู่แนวเดียวกัน (แถวเดียวหรือคอลัมน์เดียว)
     */
    public static boolean sameLine(Position a, Position b) {
        return a.getRow() == b.getRow()
                || a.getCol() == b.getCol();
    }

    /**
     * เช็คว่าอยู่แนวทแยง
     */
    public static boolean diagonal(Position a, Position b) {
        return Math.abs(a.getRow() - b.getRow())
                == Math.abs(a.getCol() - b.getCol());
    }

    // ======================================
    // Board Utility
    // ======================================

    /**
     * เช็คว่า position อยู่ในขอบเขตบอร์ดไหม
     */
    public static boolean inside(Position pos, int rows, int cols) {
        int r = pos.getRow();
        int c = pos.getCol();
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /**
     * เช็คว่า 2 position เท่ากันไหม
     */
    public static boolean same(Position a, Position b) {
        return a.getRow() == b.getRow()
                && a.getCol() == b.getCol();
    }
}