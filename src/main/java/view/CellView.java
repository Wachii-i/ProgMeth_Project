package view;

import controller.GameController;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import model.core.Position;
import model.unit.Unit;

public class CellView extends StackPane {
    private final Position position;
    private final Rectangle shape;
    private Text unitText;

    public CellView(Position pos) {
        this.position = pos;

        this.shape = new Rectangle(60, 60);
        this.shape.setFill(Color.WHITE);
        this.shape.setStroke(Color.BLACK);

        this.unitText = new Text(""); // เริ่มต้นเป็นช่องว่าง
        this.unitText.setFont(new Font(18));

        this.getChildren().addAll(shape, unitText);

        this.setOnMouseClicked(event -> {
            GameController.getInstance().handleCellClick(this.position);
        });
    }

    public void setUnit(Unit unit) {
        if (unit == null) {
            unitText.setText("");
            shape.setFill(Color.WHITE);
        } else {
            unitText.setText(unit.getClass().getSimpleName().substring(0, 1));

            if (unit.getTeam().toString().equals("TEAM_1")) {
                shape.setFill(Color.LIGHTBLUE);
            } else {
                shape.setFill(Color.LIGHTPINK);
            }
        }
    }

}
