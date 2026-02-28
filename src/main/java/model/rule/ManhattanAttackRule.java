package model.rule;

import model.unit.Unit;

public class ManhattanAttackRule implements AttackRule {

    @Override
    public boolean canAttack(Unit attacker, Unit target) {

        if (attacker == null || target == null) return false;

        if (!attacker.canAttack()) return false;

        if (!target.isAlive()) return false;

        if (attacker.getTeam() == target.getTeam()) return false;

        return attacker.distanceTo(target.getPosition())
                <= attacker.getAttackRange();
    }
}