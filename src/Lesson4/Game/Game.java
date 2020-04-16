package Lesson4.Game;

import java.util.Random;

class Game {

    private static Random randomStep    = new Random();
    private static Random randomHealing = new Random();
    private static Random randomHit     = new Random();

    public static void main(String[] args) {
        Team team1 = new Team(new Hero[]{new Warrior("Тигрил")
                                       , new Assasin("Акали")
                                       , new Doctor("Жанна")});

        Team team2 = new Team(new Hero[]{new Warrior("Минотавр")
                                       , new Assasin("Джинкс")});

        System.out.println("----- Схватка -----");
        while (team1.isTeamAlive() && team2.isTeamAlive()) {
            if (randomStep.nextInt(2) == 0){
                fight(team1, team2);
                fight(team2, team1);
            } else {
                fight(team2, team1);
                fight(team1, team2);
            }
            System.out.println("----- Раунд -----");
        }

        System.out.println("----- Схватка закончена -----");
        if(team1.isTeamAlive()){
            System.out.println("Победила команда 1:");
            team1.info();
        } else {
            System.out.println("Победила команда 2:");
            team2.info();
        }
    }

    public static void fight(Team _first, Team _second){
        for (int i = 0; i < _first.getTeamSize() && _second.isTeamAlive(); i++) {
            Hero hero = (Hero) _first.getHero(i);
            if (hero instanceof Doctor) {
                hero.healing((Hero) _first.getHero(randomHealing.nextInt(_first.getTeamSize())));
            } else {
                hero.hit((Hero) _second.getHero(randomHit.nextInt(_second.getTeamSize())));
            }
        }
    }

}