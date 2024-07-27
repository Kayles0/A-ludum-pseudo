package Kayles.main;

import Kayles.main.characters.Hero;

import java.util.Random;
import java.util.Scanner;

public class Start {
    static Scanner in = new Scanner(System.in);

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

        Random random = new Random();
        int a = random.nextInt(3);
        switch (a){
            case 0 -> System.out.println("+Hp");
            case 1 -> {
                System.out.println("Monster");
                hero.changeHp(-1);
            }
            default -> System.out.println("Nothing");
        }
        if (hero.getHp() > 0) Start.game_menu(hero);
        else System.out.println("\tYou lose\n\tGame Over");
    }

    public static void game_menu(Hero hero){
        System.out.printf("Hero hp: %d Attack: %.1f. Armor: %.1f.", hero.getHp(), hero.getAttack(), hero.getArmor());
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

}
