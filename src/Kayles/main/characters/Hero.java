package Kayles.main.characters;

public class Hero extends Default_Characters {

    public Hero(){
        super(1, 1, 1);
    }

    public Hero(int hp, double armor, double attack) {
        super(hp, armor, attack);
        int max_hp = hp;
    }

    @Override
    public double getArmor() {
        return super.getArmor();
    }

    @Override
    public double getAttack() {
        return super.getAttack();
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public void changeHp(int hp) {
        super.changeHp(hp);
    }
}
