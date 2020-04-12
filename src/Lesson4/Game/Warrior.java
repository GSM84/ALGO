package Lesson4.Game;

class Warrior extends Hero {
    private static final int HP_MAX = 300;
    private static final int HP_MIN = 250;
    private static final int DMG_MAX = 60;
    private static final int DMG_MIN = 50;

    public Warrior(String name) {
        super(name);
        super.setHealth(HP_MIN, HP_MAX);
        super.setDamage(DMG_MIN, DMG_MAX);
        System.out.println(this.toString());
    }

    public Warrior(int health, String type, int damage) {
        super(health, type, damage);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            System.out.println(this.name + " нанес урон " + this.damage + " герою " + hero.name);
            hero.causeDamage(damage);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }

    @Override
    public void setTeam(Team _team) {
        super.setTeam(_team);
    }
}
