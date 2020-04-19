package Lesson6.Game.Utils;

import Lesson6.Game.Heroes.Doctor;
import Lesson6.Game.Heroes.Hero;
import javafx.scene.control.TextArea;

import java.util.Random;

public class Game {
    private Team team1;
    private Team team2;

    private static Random randomStep    = new Random();
    private static Random randomHealing = new Random();
    private static Random randomHit     = new Random();

    public Game() {
        this.team1 = new Team();
        this.team2 = new Team();
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void startFight(TextArea _battleLog){
        int round =0;
        _battleLog.appendText("----- Схватка ----- \n");
        while (team1.isTeamAlive() && team2.isTeamAlive()) {
            if (randomStep.nextInt(2) == 0){
                fight(team1, team2, _battleLog);
                fight(team2, team1, _battleLog);
            } else {
                fight(team2, team1, _battleLog);
                fight(team1, team2, _battleLog);
            }
            round++;
            _battleLog.appendText(String.format("----- Раунд %d завершен -----\n", round));
        }

        _battleLog.appendText("----- Схватка закончена -----\n");
        if(team1.isTeamAlive()){
            _battleLog.appendText(String.format("Команда 1 победила за %d раундов(а).\n", round));
            team1.info(_battleLog);
        } else {
            _battleLog.appendText(String.format("Команда 2 победила за %d раундов(а).\n", round));
            team2.info(_battleLog);
        }
    }

    public static void fight(Team _first, Team _second, TextArea _battleLog){
        for (int i = 0; i < _first.getTeamSize() && _second.isTeamAlive(); i++) {
            Hero hero = (Hero) _first.getHero(i);
            if (hero instanceof Doctor) {
                _battleLog.appendText(((Doctor) hero).healing((Hero) _first.getHero(randomHealing.nextInt(_first.getTeamSize())))+"\n");
            } else {
                _battleLog.appendText(hero.hit((Hero) _second.getHero(randomHit.nextInt(_second.getTeamSize())))+"\n");
            }
        }
    }

    public void resetGame(){
        team1.clear();
        team2.clear();
    }
}