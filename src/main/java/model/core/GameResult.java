package model.core;

import java.util.Objects;

public final class GameResult {

    private final boolean gameOver;
    private final Team winner;   // null if game is not end
    private final String reason; // e.g "KING_DEAD"

    private GameResult(boolean gameOver, Team winner, String reason) {
        this.gameOver = gameOver;
        this.winner = winner;
        this.reason = reason;


        if (gameOver && winner == null) {
            throw new IllegalArgumentException("winner must not be null when gameOver is true");
        }
        if (!gameOver && winner != null) {
            throw new IllegalArgumentException("winner must be null when gameOver is false");
        }
    }

    //method

    //game is not end
    public static GameResult ongoing() {
        return new GameResult(false, null, null);
    }

    // End Game And Have Winner
    public static GameResult win(Team winner, String reason) {
        Objects.requireNonNull(winner, "winner cannot be null");
        return new GameResult(true, winner, reason);
    }

    //=======getter=======
    public boolean isGameOver() {
        return gameOver;
    }

    public Team getWinner() {
        return winner;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        if (!gameOver) {
            return "GameResult{ONGOING}";
        }
        return "GameResult{WINNER=" + winner + ", reason=" + reason + "}";
    }
}