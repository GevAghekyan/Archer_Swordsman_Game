package com.company.entities;

import java.util.Random;

public abstract class Warrior {

    private Integer health;
    private Integer attack;
    private Integer defense;
    private Integer hitPercent;

    private Random random = new Random();

    public Warrior() {
    }

    public Warrior(Integer health, Integer hitPercent, Integer defense) {
        this.health = health;
        this.hitPercent = hitPercent;
        this.defense = defense;
        generateAttack();
    }

    public Integer hit(Warrior warrior) {
        generateAttack();
        warrior.setHealth(warrior.getHealth() - (this.attack - warrior.getDefense()));
        return warrior.getHealth();
    }

    public void generateAttack() {
        this.attack = random.nextInt(hitPercent) + 50;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warrior warrior = (Warrior) o;

        if (health != null ? !health.equals(warrior.health) : warrior.health != null) return false;
        if (attack != null ? !attack.equals(warrior.attack) : warrior.attack != null) return false;
        return defense != null ? defense.equals(warrior.defense) : warrior.defense == null;
    }

    @Override
    public int hashCode() {
        int result = health != null ? health.hashCode() : 0;
        result = 31 * result + (attack != null ? attack.hashCode() : 0);
        result = 31 * result + (defense != null ? defense.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}
