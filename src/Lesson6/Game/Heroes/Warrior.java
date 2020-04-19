package Lesson6.Game.Heroes;

import Lesson6.Game.Utils.Team;

public class Warrior extends Hero {
    private static final int HP_MAX = 300;
    private static final int HP_MIN = 250;
    private static final int DMG_MAX = 60;
    private static final int DMG_MIN = 50;

    public Warrior(String name) {
        super(name);
        super.setHealth(HP_MIN, HP_MAX);
        super.setDamage(DMG_MIN, DMG_MAX);
    }

    public Warrior(int health, String type, int damage) {
        super(health, type, damage);
    }

    @Override
    public String hit(Hero hero) {
        if (hero != this) {
            return String.format("%s нанес урон %d герою %s.\n %s", this.name, this.damage, hero.name, hero.causeDamage(damage));
        }
        return null;
    }

    @Override
    String healing(Hero hero) {
        return "Войны не умеют лечить!";
    }

    @Override
    public void setTeam(Team _team) {
        super.setTeam(_team);
    }
}
