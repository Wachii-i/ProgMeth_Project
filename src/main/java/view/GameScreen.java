package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.board.Board;

public class GameScreen extends BorderPane {

    private BoardView boardView;
    private Text turnIndicator;

    public GameScreen(Board board) {
        this.setPadding(new Insets(20));

        VBox topBar = new VBox();
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(0, 0, 20, 0));

        turnIndicator = new Text("Team 1's Turn");
        turnIndicator.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        topBar.getChildren().add(turnIndicator);

        this.setTop(topBar);

        this.boardView = new BoardView(board);
        this.setCenter(boardView);

        // VBox sideBar = new VBox();
        // this.setRight(sideBar);
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void updateTurnText(String text) {
        turnIndicator.setText(text);
    }
}