package Lesson4.Game;

import java.util.Random;

class Assasin extends Hero {
    private static final int HP_MAX = 185;
    private static final int HP_MIN = 150;
    private static final int DMG_MAX = 80;
    private static final int DMG_MIN = 65;

    int cricitalHit;
    Random random = new Random();

    public Assasin(int heal, String name, int damage) {
        super(heal, name, damage);
        this.cricitalHit = random.nextInt(20);
    }

    public Assasin(String name) {
        super(name);
        super.setHealth(HP_MIN, HP_MAX);
        super.setDamage(DMG_MIN, DMG_MAX);
        this.cricitalHit = random.nextInt(20);
        System.out.println(this.toString());
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            System.out.println(this.name + " нанес урон " + this.damage + " герою " + hero.name);
            hero.causeDamage(damage + cricitalHit);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }

    @Override
    public void setTeam(Team _team) {
        super.setTeam(_team);
    }
}