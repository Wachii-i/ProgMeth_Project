package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import model.board.Board;
import model.core.Position;

public class BoardView extends GridPane {
    private final int SIZE = 6;
    private final CellView[][] cellViews = new CellView[SIZE][SIZE];

    public BoardView(Board board) {
        this.setAlignment(Pos.CENTER);
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                CellView cellView = new CellView(new Position(row, col));
                cellViews[row][col] = cellView;

                this.add(cellView, col ,row);
            }
        }
    }
}
