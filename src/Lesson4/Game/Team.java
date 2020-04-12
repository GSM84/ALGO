package Lesson4.Game;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class Team<Hero> {
    private ArrayList<Hero> team = new ArrayList<>();
    private ArrayList<Hero> dead = new ArrayList<>();

    public Team(Hero[] _heroes){
        for (int i = 0; i < _heroes.length; i++) {
            if (_heroes[i] instanceof Warrior) {
                Warrior w = (Warrior)_heroes[i];
                w.setTeam(this);
            } else if(_heroes[i] instanceof Assasin) {
                Assasin a = (Assasin)_heroes[i];
                a.setTeam(this);
            } else if (_heroes[i] instanceof Doctor){
                Doctor d = (Doctor)_heroes[i];
                d.setTeam(this);
            }

            team.add(_heroes[i]);
        }
    }

    public Team(){

    }

    public void addHero(Hero _hero){
        team.add(_hero);
    }

    public Hero getHero(int _index){
        return team.get(_index);
    }

    public void removeHero(Hero _hero){
        this.team.remove(_hero);
    }

    public boolean isTeamAlive(){
        return team.size() > 0;
    }

    public int getTeamSize(){
        return team.size();
    }

    public void markDead(Hero _hero){
        dead.add(_hero);
    }

    public void info(){
        System.out.println("Живые герои: ");
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).toString());
        }
        if (dead.size() > 0) {
            System.out.println("Мертвые герои: ");
            for (int i = 0; i < dead.size(); i++) {
                System.out.println(dead.get(i).toString());
            }
        }
    }
}
