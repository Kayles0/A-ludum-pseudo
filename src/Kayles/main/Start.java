package Kayles.main;

import Kayles.main.characters.BestiaryofMonsters;
import Kayles.main.characters.Hero;

import javax.management.monitor.MonitorMBean;
import java.util.Random;
import java.util.Scanner;

public class Start {
    static Scanner in = new Scanner(System.in);
    static Random random = new Random();

    public static void start(){
        System.out.println("Create your Hero\nYou have 30 points\nPut the points in their places: Hp, attack, armor (attack and armor is double, hp is int)");
        int hp = in.nextInt();
        double attack = in.nextDouble(), armor = in.nextDouble();
        while (hp + attack + armor != 30){
            System.out.println("Correct the values\nThere should be 30 in total!");
            hp = in.nextInt();
            attack = in.nextDouble();
            armor = in.nextDouble();
        }
        Hero hero = new Hero(hp, armor, attack);
        System.out.println("You start your story...");
        Start.game_menu(hero);
    }

    public static void find(Hero hero){
        int a = random.nextInt(7);
        switch (a){
            case 0,1 -> {
                int hp_random = random.nextInt(4) + 1;
                System.out.println("+Hp" + hp_random);
                hero.changeHp(hp_random);
            }
            case 2,3 -> {
                System.out.println("Monster <lvl 1> Hp: 5 armor: 0.5 attack: 1.5");
                Start.fight(hero, new BestiaryofMonsters.Monster_Standart(1));
            }
            case 4,5 -> {
                System.out.println("Monster <lvl 2> Hp: 10 armor: 1 attack: 3");
                Start.fight(hero, new BestiaryofMonsters.Monster_Standart(2));
            }
            case 6 -> {
                System.out.println("Monster <lvl 3> Hp: 15 armor: 1.5 attack: 4.5");
                Start.fight(hero, new BestiaryofMonsters.Monster_Standart(3));
            }
            default -> System.out.println("Nothing");
        }
        if (hero.getHp() > 0) Start.game_menu(hero);
        else System.out.println("\tYou lose\n\tGame Over");
    }

    public static void game_menu(Hero hero){
        System.out.printf("\nHero hp: %d/%d Attack: %.1f. Armor: %.1f.", hero.getHp(),hero.getMax_hp(), hero.getAttack(), hero.getArmor());
        System.out.println("\nWhat will we do?\n\t1.Find something\n\t2.Check inventory (in dev >_<)\n\t3.Change location (in dev >_<)");
        byte m = in.nextByte();
        switch (m){
            case 1 -> Start.find(hero);
            case 2, 3 -> {
                System.out.println("In developing >_<");
                Start.game_menu(hero);
            }
        }
    }

    public static void fight(Hero hero, BestiaryofMonsters.Monster_Standart Monster_Standart){
        System.out.printf("\n\tYour hp: %d/%d attack: %.1f. armor: %.1f.", hero.getHp(),hero.getMax_hp(), hero.getAttack(), hero.getArmor());
        System.out.printf("\n\tMonster's hp: %d/%d attack: %.1f. armor: %.1f.", Monster_Standart.getHp(),Monster_Standart.getMax_hp(), Monster_Standart.getAttack(), Monster_Standart.getArmor());
        System.out.println("\nWhat do you want to do? \n\t*1* Attack! \n\t*2* Defense.\n\t*3*Run?");
        byte choose = in.nextByte();
        switch (choose){
            case 1 -> {
                System.out.printf("\nYou attacked for %d damage", (int)Math.round(hero.getAttack()));
                System.out.printf("\nYou took %d damage", (int)Math.round(Monster_Standart.getAttack()));
                hero.changeHp(-(int)Math.round(Monster_Standart.getAttack()));
                Monster_Standart.changeHp(-(int)Math.round(hero.getAttack()));
            }
            case 2 -> {
                int defense_random = random.nextInt(10);
                switch (defense_random){
                    case 0, 1, 2-> {
                        System.out.printf("\n\tPERFECT BLOCK\nSuccessfully blocked %d", Mechanics.defense(Monster_Standart.getAttack(),hero.getArmor()*2));
                        hero.changeHp((int)Math.round(Monster_Standart.getAttack()-Mechanics.defense(Monster_Standart.getAttack(),hero.getArmor()*2)));
                    }
                    case 3,4,5,6,7 -> {
                        System.out.printf("\n\tBase block\nSuccessfully blocked %d", Mechanics.defense(Monster_Standart.getAttack(),hero.getArmor()));
                        hero.changeHp(-(int)(Math.round(Monster_Standart.getAttack()-Mechanics.defense(Monster_Standart.getAttack(),hero.getArmor()))));
                    }
                    case  8,9 -> {
                        System.out.printf("\n\tBAD BLOCK\nSuccessfully blocked %d", Mechanics.defense(Monster_Standart.getAttack()*2,hero.getArmor()));
                        hero.changeHp(-(int)(Math.round(Monster_Standart.getAttack()-Mechanics.defense(Monster_Standart.getAttack()*2,hero.getArmor()))));
                    }
                    case 10 -> {
                        System.out.printf("\n\tPARRYING!!!\n\tYou take no damage and deal %d damage in return", Math.round(hero.getAttack()*1.7));
                        Monster_Standart.changeHp(-(int)Math.round(hero.getAttack()*1.7));
                    }
                }
            }
            case 3 -> {
                int run_random = random.nextInt(5);
                switch (run_random){
                    case 0, 1, 2 -> {
                        System.out.println("You successfully escaped");
                        Start.game_menu(hero);
                    }
                    case 3, 4 -> {
                        System.out.printf("You successfully escaped, but took %d damage", Math.round(Monster_Standart.getAttack()));
                        hero.changeHp(-(int)Math.round(Monster_Standart.getAttack()));
                        Start.game_menu(hero);
                    }
                    case 5 -> {
                        System.out.printf("You didn't run away and took %d damage", Math.round(Monster_Standart.getAttack() * 1.7));
                        hero.changeHp(-(int)Math.round(Monster_Standart.getAttack() * 1.7));
                    }
                }
            }
        }


        if (hero.getHp() <= 0) {
            System.out.println("\n\tYou lose fight\n\tGame Over");
            Start.start();
        }
        else if (Monster_Standart.getHp() <= 0) {
            System.out.println("\n\tYou won fight!!!");
            Start.game_menu(hero);
        }
        else Start.fight(hero, Monster_Standart);
    }

}
