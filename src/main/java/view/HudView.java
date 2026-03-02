package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class HudView extends HBox {

    private final Text turnText;

    public HudView() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        this.turnText = new Text("Current Turn: -");
        this.turnText.setFont(new Font(22));

        this.getChildren().add(turnText);
    }

    // ให้ Controller/GameScreen เรียก
    public void updateTurn(String text) {
        turnText.setText(text == null ? "" : text);
    }

    public String getTurnText() {
        return turnText.getText();
    }
}