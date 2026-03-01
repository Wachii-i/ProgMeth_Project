package controller;

import javafx.scene.control.Alert;
import model.board.Board;
import model.core.Position;
import model.core.Team;
import view.GameScreen;

public class GameController {

    private static GameController instance;

    private Board board;
    private GameScreen gameScreen;
    private Team currentTurn;

    private GameController() {
        this.currentTurn = Team.RED;
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void setupGame(Board board, GameScreen screen) {
        this.board = board;
        this.gameScreen = screen;

        // อัปเดตข้อความเทิร์นตอนเริ่มเกม
        if (gameScreen != null) {
            gameScreen.updateTurnText("Current Turn: " + currentTurn);
        }
    }

    // =============================
    // Handle Click
    // =============================

    public void handleCellClick(Position pos) {
        if (board == null) return;

        if (!board.isInside(pos)) {
            showError("Invalid Position", "Position is outside the board.");
            return;
        }

        if (!board.isEmpty(pos)) {
            showError("Invalid Move", "Cell is already occupied.");
            return;
        }

        if (!isValidPlacement(pos)) {
            showError("Notice", "Your team cannot place here.");
            return;
        }

        // ตรงนี้สมมติว่าแค่ log ก่อน (เพราะยังไม่ได้ place unit จริง)
        System.out.println(currentTurn + " placed at "
                + pos.getRow() + "," + pos.getCol());

        switchTurn();
    }

    // =============================
    // Placement Logic
    // =============================

    private boolean isValidPlacement(Position pos) {

        int col = pos.getCol();
        int mid = board.getCols() / 2;

        if (currentTurn == Team.RED) {
            return col < mid;   // RED ฝั่งซ้าย
        } else {
            return col >= mid;  // BLUE ฝั่งขวา
        }
    }

    // =============================
    // Turn Logic
    // =============================

    private void switchTurn() {
        currentTurn = currentTurn.opposite();

        if (gameScreen != null) {
            gameScreen.updateTurnText("Current Turn: " + currentTurn);
        }
    }

    // =============================
    // UI Error Helper
    // =============================

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Team getCurrentTurn() {
        return currentTurn;
    }
}