package Kayles.main.characters;

public class Default_Characters {
    int hp;
    double armor, attack;
    public Default_Characters() {
    }
    public Default_Characters(int hp, double armor, double attack) {
        this.hp = hp;
        this.armor = armor;
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public double getArmor() {
        return armor;
    }

    public double getAttack() {
        return attack;
    }
}
