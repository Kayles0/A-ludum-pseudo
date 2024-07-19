package Kayles.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to <Ludum Pseudo>");
        welcome_menu();
    }

    protected static void welcome_menu() {
        System.out.println("\t<Menu>");
        System.out.println("\t*1* Start \n\t*2* Settings (Developing) \n\t*3* Exit");
        Scanner in = new Scanner(System.in);
        byte q = in.nextByte();
        switch (q) {
            case 1 -> Start.start();
            case 2 -> Settings.settings();
            case 3 -> {
                System.out.println("Are u sure? .-.\n\t *1* <yes>\t*2* <no>");
                byte exit_check = in.nextByte();
                if (exit_check == 1) {
                    System.out.println("Bye :(");
                    System.exit(0);
                }
                else {
                    welcome_menu();
                }

            }
            default -> {
                System.out.println("Input error");
                welcome_menu();
            }
        }
    }
}
