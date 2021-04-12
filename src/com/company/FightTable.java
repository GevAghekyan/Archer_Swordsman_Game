package com.company;

public class FightTable {

    private String archerName = "Archer";
    private String swordsmanName = "Swordsman";
    private Integer archerHealth;
    private Integer swordsmanHealth;

    public FightTable() {
    }

    public FightTable(Integer archerHealth, Integer swordsmanHealth) {
        this.archerHealth = archerHealth;
        this.swordsmanHealth = swordsmanHealth;
    }

    public String getArcherName() {
        return archerName;
    }

    public String getSwordsmanName() {
        return swordsmanName;
    }

    public Integer getArcherHealth() {
        return archerHealth;
    }

    public void setArcherHealth(Integer archerHealth) {
        this.archerHealth = archerHealth;
    }

    public Integer getSwordsmanHealth() {
        return swordsmanHealth;
    }

    public void setSwordsmanHealth(Integer swordsmanHealth) {
        this.swordsmanHealth = swordsmanHealth;
    }

    @Override
    public String toString() {
        return "archerHealth=" + archerHealth + "\n" +
                "swordsmanHealth=" + swordsmanHealth;
    }
}
