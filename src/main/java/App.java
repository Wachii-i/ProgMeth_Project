import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.board.Board;
import view.GameScreen;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Board board = new Board(6,6);

        GameScreen gameScreen = new GameScreen(board);

        Scene scene = new Scene(gameScreen, 600, 700);

        GameController.getInstance().setupGame(board, gameScreen);
        
        primaryStage.setTitle("King Guard Game");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}