package view;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import model.board.Board;
import model.core.Position;
import model.unit.Unit;

public class BoardView extends GridPane {

    private final CellView[][] cellViews;
    private final int rows;
    private final int cols;

    public BoardView(Board board) {
        this.setAlignment(Pos.CENTER);

        this.rows = board.getRows();
        this.cols = board.getCols();
        this.cellViews = new CellView[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                CellView cellView = new CellView(new Position(r, c));
                cellViews[r][c] = cellView;
                this.add(cellView, c, r);
            }
        }


        refresh(board);
    }
    public void refresh(Board board) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Position pos = new Position(r, c);

                Unit unit = board.getUnitAt(pos);

                cellViews[r][c].setUnit(unit);
            }
        }
    }
    public CellView getCellView(Position pos) {
        return cellViews[pos.getRow()][pos.getCol()];
    }
}