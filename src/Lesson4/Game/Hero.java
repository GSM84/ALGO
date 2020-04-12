package Lesson4.Game;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;
    private Team team;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    public Hero(int health, String name, int damage) {
        this.health = health;
        this.name = name;
        this.damage = damage;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if (health > 0) {
            health -= damage;
            if (health <= 0) {
                System.out.println("Герой " + name + " убит.");
                team.removeHero(this);
                team.markDead(this);
            } else {
                System.out.println(name + " осталось " + health + " здоровья.");
            }
        }
    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    void info() {

        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    public boolean isAlive(){
        return health > 0;
    }

    protected void setTeam(Team _team) {
        this.team = _team;
    }

    @Override
    public String toString() {
        return "Герой " + name +
               ", урон " + damage +
               ", осталось здоровья " + ((health > 0)?health:0);
    }

    private int getRandom(int _from, int _too){
        return (int) (Math.random() * (_too + 1 - _from) + _from);
    }

    protected  void setHealth(int _from, int _too){
        health = getRandom(_from, _too);
    }

    protected  void setDamage(int _from, int _too){
        damage = getRandom(_from, _too);
    }

    protected  void setHeal(int _from, int _too){
        addHeal = getRandom(_from, _too);
    }
}
