package model.rule;

import model.board.Board;
import model.core.GameResult;

public interface WinCondition {
    GameResult check(Board board);
}