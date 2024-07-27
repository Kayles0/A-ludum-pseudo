package Kayles.main;

public class Mechanics {
    public static int defense(double attack, double defense){
        if (attack >= defense){
            return (int)(defense);
        }
        else return (int) attack;
    }
}
