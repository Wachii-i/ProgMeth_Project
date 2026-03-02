package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import model.board.Board;

public class GameScreen extends BorderPane {

    private final BoardView boardView;
    private final HudView hudView;

    public GameScreen(Board board) {

        this.setPadding(new Insets(20));

        // HUD ด้านบน
        this.hudView = new HudView();
        this.setTop(hudView);

        // กระดาน
        this.boardView = new BoardView(board);
        this.setCenter(boardView);
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void refresh(Board board) {
        boardView.refresh(board);
    }

    // ให้ GameController เรียกเหมือนเดิม
    public void updateTurnText(String text) {
        hudView.updateTurn(text);
    }
}