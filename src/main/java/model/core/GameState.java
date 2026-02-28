package model.core;

public class GameState {

    // ===== Constants =====
    public static final int MAX_ACTION_POINTS = 3;

    // ===== Fields =====
    private Team currentTurn;
    private Phase phase;
    private int actionPoints;

    private String selectedUnitId;   // null = ยังไม่ได้เลือกยูนิต

    private GameResult result;       // ongoing / win

    // ===== Constructor =====
    public GameState(Team startingTeam) {
        this.currentTurn = startingTeam;
        this.result = GameResult.ongoing();
        startTurn(); // set phase + AP + clear selection
    }

    // ===== Turn Control =====

    /** เริ่มเทิร์นของทีมปัจจุบัน (รีเซ็ต AP/phase/selection) */
    public void startTurn() {
        this.actionPoints = MAX_ACTION_POINTS;
        this.phase = Phase.SELECT_UNIT;
        this.selectedUnitId = null;
    }

    /** ใช้เมื่อกด End Turn หรือ AP หมดแล้วต้องสลับทีม */
    public void endTurn() {
        this.currentTurn = this.currentTurn.opposite();
        startTurn();
    }

    /** ตัด Action 1 แต้ม (เรียกหลัง move หรือ attack สำเร็จ) */
    public void spendAction() {
        if (actionPoints <= 0) {
            throw new IllegalStateException("No action points left");
        }
        actionPoints--;
    }

    public boolean hasActionPoints() {
        return actionPoints > 0;
    }

    // ===== Selection & Phase =====

    public void selectUnit(String unitId) {
        this.selectedUnitId = unitId;
        this.phase = Phase.CHOOSE_ACTION;
    }

    public void clearSelection() {
        this.selectedUnitId = null;
        this.phase = Phase.SELECT_UNIT;
    }

    public boolean hasSelectedUnit() {
        return selectedUnitId != null;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    // ===== Game Over =====

    /** ตั้งค่าผลเกมเมื่อจบ (เช่น KING_DEAD) */
    public void setResult(GameResult result) {
        this.result = result;
    }

    public boolean isGameOver() {
        return result.isGameOver();
    }

    // ===== Getters =====

    public Team getCurrentTurn() { return currentTurn; }
    public Phase getPhase() { return phase; }
    public int getActionPoints() { return actionPoints; }
    public String getSelectedUnitId() { return selectedUnitId; }
    public GameResult getResult() { return result; }

    @Override
    public String toString() {
        return "GameState{" +
                "turn=" + currentTurn +
                ", phase=" + phase +
                ", AP=" + actionPoints +
                ", selectedUnitId=" + selectedUnitId +
                ", result=" + result +
                '}';
    }
}