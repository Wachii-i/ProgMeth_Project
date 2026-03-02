package view;

import controller.GameController;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.core.Position;
import model.core.Team;
import model.unit.Unit;

public class CellView extends StackPane {

    private final Position position;
    private final Rectangle shape;
    private final Text unitText;

    private static final double CELL_SIZE = 60;

    public CellView(Position pos) {
        this.position = pos;

        this.shape = new Rectangle(CELL_SIZE, CELL_SIZE);
        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);

        this.unitText = new Text("");
        this.unitText.setFont(new Font(18));

        this.getChildren().addAll(shape, unitText);

        this.setOnMouseClicked(event -> {
            GameController.getInstance().handleCellClick(this.position);
        });
    }

    public Position getPosition() {
        return position;
    }

    public void setUnit(Unit unit) {
        if (unit == null) {
            unitText.setText("");
            shape.setFill(Color.WHITE);
            return;
        }


        unitText.setText(getDisplaySymbol(unit));


        Team team = unit.getTeam();
        if (team == Team.RED) {
            shape.setFill(Color.LIGHTPINK);
        } else if (team == Team.BLUE) {
            shape.setFill(Color.LIGHTBLUE);
        } else {
            shape.setFill(Color.LIGHTGRAY);
        }
    }

    // ===== helper =====
    private String getDisplaySymbol(Unit unit) {
        String name = unit.getClass().getSimpleName();


        if (name == null || name.isEmpty()) return "?";


        return name.substring(0, 1).toUpperCase();
    }
}