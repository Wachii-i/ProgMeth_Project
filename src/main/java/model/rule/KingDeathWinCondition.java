package model.rule;

import model.board.Board;
import model.core.GameResult;
import model.core.Position;
import model.core.Team;
import model.unit.King;
import model.unit.Unit;

public class KingDeathWinCondition implements WinCondition {

    @Override
    public GameResult check(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("board cannot be null");
        }

        boolean redKingAlive = false;
        boolean blueKingAlive = false;

        // วนทุกช่องเพื่อหา King ของแต่ละทีม
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {

                Unit u = board.getUnitAt(new Position(r, c));
                if (u == null) continue;

                if (u instanceof King && u.isAlive()) {
                    if (u.getTeam() == Team.RED) redKingAlive = true;
                    if (u.getTeam() == Team.BLUE) blueKingAlive = true;
                }
            }
        }

        // ถ้าทั้งคู่ยังมี King อยู่ -> เกมยังไม่จบ
        if (redKingAlive && blueKingAlive) {
            return GameResult.ongoing();
        }

        // ถ้า RED ไม่มี King -> BLUE ชนะ
        if (!redKingAlive) {
            return GameResult.win(Team.BLUE, "RED king is dead");
        }

        // ถ้า BLUE ไม่มี King -> RED ชนะ
        return GameResult.win(Team.RED, "BLUE king is dead");
    }
}