package com.company;

import com.company.entities.Archer;
import com.company.entities.Swordsman;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        Archer archer = new Archer();
        Swordsman swordsman = new Swordsman();

        File file = new File("C:\\Users\\gevor\\Desktop\\table.txt");

        if (file.exists()) {
            Fight.inputFile(archer, swordsman, file);
        }

        Fight.startFight(archer, swordsman);

        Fight.endFight(archer, swordsman, file);

    }
}