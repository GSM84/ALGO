package Lesson4.Game;

class Doctor extends Hero {
    private static final int HP_MAX = 200;
    private static final int HP_MIN = 160;
    private static final int HEAL_MAX = 60;
    private static final int HEAL_MIN = 40;

    public Doctor(String name) {
        super(name);
        super.setHealth(HP_MIN, HP_MAX);
        super.setHeal(HEAL_MIN, HEAL_MAX);
        System.out.println(this.toString());
    }

    public Doctor(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Восстанавливает здоровье " +(this.addHeal) + " герою "+ hero.name);

        hero.addHealth(addHeal);
    }

    @Override
    public void setTeam(Team _team) {
        super.setTeam(_team);
    }

    @Override
    public String toString() {
        return "Герой " + name +
               ", урон " + damage +
               ", лечение " + addHeal +
               ", осталось здоровья " + ((health > 0)?health:0);
    }
}
