package com.company;

import com.company.entities.Archer;
import com.company.entities.Swordsman;
import com.company.entities.Warrior;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fight {

    public static FightTable fight(Warrior archer, Warrior swordsman) {
        FightTable fightTable = new FightTable();
        archer.hit(swordsman);
        swordsman.hit(archer);
        fightTable.setArcherHealth(archer.getHealth());
        fightTable.setSwordsmanHealth(swordsman.getHealth());
        return fightTable;
    }

    public static void endFight(Archer archer, Swordsman swordsman, File file) {
        if (archer.getHealth() == 0 && swordsman.getHealth() == 0) {
            System.out.println("Its draw!!!");
        } else if (archer.getHealth() == 0) {
            System.out.println("Swordsman wins!!!");
        } else {
            System.out.println("Archer wins!!!");
        }
        file.delete();
    }

    public static void startFight(Archer archer, Swordsman swordsman) {
        Scanner scanner = new Scanner(System.in);

        Integer count = 1;
        System.out.println("Press Enter to fight:" + "\n");
        while (archer.getHealth() > 0 && swordsman.getHealth() > 0) {
            System.out.println(archer);
            System.out.println(swordsman);
            if (scanner.nextLine().equals("")) {
                FightTable fightResult = Fight.fight(archer, swordsman);
                try (OutputStream fos = new FileOutputStream("C:\\Users\\gevor\\Desktop\\table.txt")) {
                    fos.write(fightResult.toString().getBytes());
                    System.out.println("Round" + count + ":");
                    count++;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("PRESS ENTER!!!");
            }
        }
    }

    public static void inputFile(Archer archer, Swordsman swordsman, File file) {
        try (InputStream fis = new FileInputStream(file)) {
            String info = new String(fis.readAllBytes());
            List<String> collect = Arrays.stream(info.split("\n"))
                    .map(s -> s.substring(s.indexOf("=") + 1))
                    .collect(Collectors.toList());
            archer.setHealth(Integer.valueOf(collect.get(0)));
            swordsman.setHealth(Integer.valueOf(collect.get(1)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}