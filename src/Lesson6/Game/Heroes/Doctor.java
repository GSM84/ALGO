package Lesson6.Game.Heroes;

import Lesson6.Game.Utils.Team;

public class Doctor extends Hero {
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
    public String hit(Hero hero) {
         return "Доктор не может бить!";
    }

    @Override
    public String healing(Hero hero) {
        hero.addHealth(addHeal);
        return String.format("Восстанавливает здоровье %d герою %s", this.addHeal, hero.name);
    }

    @Override
    public void setTeam(Team _team) {
        super.setTeam(_team);
    }


}
