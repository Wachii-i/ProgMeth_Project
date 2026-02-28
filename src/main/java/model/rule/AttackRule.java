package model.rule;

import model.unit.Unit;

public interface AttackRule {
    boolean canAttack(Unit attacker, Unit target);
}