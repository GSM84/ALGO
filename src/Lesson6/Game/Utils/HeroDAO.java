package Lesson6.Game.Utils;

import Lesson6.Game.Heroes.Assasin;
import Lesson6.Game.Heroes.Doctor;
import Lesson6.Game.Heroes.Hero;
import Lesson6.Game.Heroes.Warrior;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HeroDAO {
    public static ObservableList<Hero> getHeroList() {
        Hero[] heroes = new Hero[]{
                new Warrior("Тигрил")
                , new Assasin("Акали")
                , new Doctor("Жанна")
                , new Warrior("Минотавр")
                , new Assasin("Джинкс")
                , new Doctor("Сона")
        };

        ObservableList<Hero> list = FXCollections.observableArrayList(heroes);

        return list;
    }
}
