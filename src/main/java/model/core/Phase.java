package model.core;

public enum Phase {
    SELECT_UNIT,          // ยังไม่เลือกยูนิต
    CHOOSE_ACTION,        // เลือกแล้ว: จะเดินหรือจะตี (ถ้าตีได้)
    SELECT_MOVE_TARGET,   // เลือกช่องที่จะเดิน
    SELECT_ATTACK_TARGET  // เลือกศัตรูที่จะโจมตี
}
