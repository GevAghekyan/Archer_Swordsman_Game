package com.company.entities;

public class Swordsman extends Warrior {

    public Swordsman() {
        super(1000, 40, 15);
    }

    @Override
    public String toString() {
        return "Swordsman{" +
                "health=" + super.getHealth() +
                ", attack=" + super.getAttack() +
                ", defense=" + super.getDefense() +
                '}';
    }

}
