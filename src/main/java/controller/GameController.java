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
        this.currentTurn = Team.TEAM_1;
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
    }

    public void handleCellClick(Position pos) {
        if (isValidPlacement(pos)) {
            System.out.println(currentTurn + " placed at " + pos.getRow() + "," + pos.getCol());

            switchTurn();
        } else {
            showError("Notice","Your team can not place here");
        }
    }

    private boolean isValidPlacement(Position pos) {
        int col = pos.getCol();
        if (currentTurn == Team.TEAM_1) { return col <= 2; }
        else { return col >= 3;}
    }

    private void switchTurn() {
        currentTurn = (currentTurn == Team.TEAM_1) ? Team.TEAM_2 : Team.TEAM_1;
        // Update screen turn
        if (gameScreen != null) {
            gameScreen.updateTurnText("Current Turn: " + currentTurn);
        }
    }

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