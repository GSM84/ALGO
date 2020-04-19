package Lesson6.Game.Utils;

import Lesson6.Game.Heroes.Assasin;
import Lesson6.Game.Heroes.Doctor;
import Lesson6.Game.Heroes.Warrior;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Team<Hero> {
    private ArrayList<Hero> team = new ArrayList<>();
    private ArrayList<Hero> dead = new ArrayList<>();

    private final int teamMaxSize = 3;

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
        if (_hero instanceof Warrior) {
            Warrior w = (Warrior)_hero;
            w.setTeam(this);
        } else if(_hero instanceof Assasin) {
            Assasin a = (Assasin)_hero;
            a.setTeam(this);
        } else if (_hero instanceof Doctor){
            Doctor d = (Doctor)_hero;
            d.setTeam(this);
        }
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

    public int getTeamMaxSize() {
        return teamMaxSize;
    }

    public void info(TextArea _battleLog){
        _battleLog.appendText("Живые герои:\n");
        for (int i = 0; i < team.size(); i++) {
            _battleLog.appendText(team.get(i).toString() + "\n");
        }
        if (dead.size() > 0) {
            _battleLog.appendText("Мертвые герои:\n");
            for (int i = 0; i < dead.size(); i++) {
                _battleLog.appendText(dead.get(i).toString()+ "\n");
            }
        }
    }

    void clear(){
        team.clear();
        dead.clear();
    }
}
