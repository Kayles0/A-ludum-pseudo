package Kayles.main.characters;

public class Default_Characters {
    int hp, max_hp;
    double armor, attack;
    public Default_Characters() {
    }
    public Default_Characters(int hp, double armor, double attack) {
        this.hp = hp;
        this.armor = armor;
        this.attack = attack;
        max_hp = hp;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
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

    public void changeHp(int hp){
        this.hp += hp;
        if (this.hp > max_hp) this.hp = max_hp;
    }
}
