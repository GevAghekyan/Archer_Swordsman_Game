package com.company.entities;

public class Archer extends Warrior {

    public Archer() {
        super(1000, 55, 10);
    }

    @Override
    public String toString() {
        return "Archer{" +
                "health=" + super.getHealth() +
                ", attack=" + super.getAttack() +
                ", defense=" + super.getDefense() +
                '}';
    }
}
