package Lesson6.Game;

import Lesson6.Game.Heroes.Hero;
import Lesson6.Game.Utils.Game;
import Lesson6.Game.Utils.HeroDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class Main extends Application {
    Game game;
    @Override
    public void start(Stage primaryStage) throws Exception{
        game = initGame();
        createScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    void createScene(Stage primaryStage){
        primaryStage.setTitle("DOTa game");
        Scene scene = new Scene(new Group(), 810, 400);
        ComboBox<Hero> teamOneSelector = new ComboBox<Hero>();
        ComboBox<Hero> teamTwoSelector = new ComboBox<Hero>();
        Button addToTeam1  = new Button ("Add to team one");

        Button addToTeam2  = new Button ("Add to team two");
        Button startFight  = new Button ("Begin fight");
        startFight.setMaxWidth(100);
        startFight.setDisable(true);
        Button restart     = new Button ("Restart");
        restart.setDisable(true);

        restart.setMaxWidth(100);
        Alert al = new Alert(INFORMATION);

        ObservableList<Hero> list = HeroDAO.getHeroList();

        teamOneSelector.setItems(list);
        teamOneSelector.getSelectionModel().selectFirst();
        teamTwoSelector.setItems(list);
        teamTwoSelector.getSelectionModel().selectFirst();

        TextArea teamOneSetup = new TextArea ("");
        teamOneSetup.setMaxWidth(400);
        teamOneSetup.setMaxHeight(100);
        teamOneSetup.setEditable(false);

        TextArea teamTwoSetup = new TextArea ("");
        teamTwoSetup.setMaxWidth(400);
        teamTwoSetup.setMaxHeight(100);
        teamTwoSetup.setEditable(false);

        TextArea battleLog    = new TextArea("");
        battleLog.setMaxWidth(600);
        battleLog.setMaxHeight(400);
        battleLog.setEditable(false);

        addToTeam1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getTeam1().getTeamSize() < game.getTeam1().getTeamMaxSize()) {
                    Hero temp = teamOneSelector.getValue();
                    game.getTeam1().addHero(temp);
                    teamOneSetup.appendText(temp.printInfo() + "\n");
                    teamOneSelector.getItems().remove(temp);
                    teamOneSelector.getSelectionModel().selectFirst();
                    teamTwoSelector.getSelectionModel().selectFirst();
                } else {
                    al.setTitle("Статус команды");
                    al.setHeaderText("Конмада заполнена 1!");
                    al.show();
                    addToTeam1.setDisable(true);
                }
                if (game.getTeam1().getTeamSize() > 0 && game.getTeam2().getTeamSize() > 0)
                    startFight.setDisable(false);
            }
        });

        addToTeam2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (game.getTeam2().getTeamSize() < game.getTeam2().getTeamMaxSize()) {
                    Hero temp = teamTwoSelector.getValue();
                    game.getTeam2().addHero(temp);
                    teamTwoSetup.appendText(temp.printInfo() + "\n");
                    teamTwoSelector.getItems().remove(temp);
                    teamTwoSelector.getSelectionModel().selectFirst();
                    teamOneSelector.getSelectionModel().selectFirst();
                } else {
                    al.setTitle("Статус команды");
                    al.setHeaderText("Конмада заполнена 2!");
                    al.show();
                    addToTeam2.setDisable(true);
                }
                if (game.getTeam1().getTeamSize() > 0 && game.getTeam2().getTeamSize() > 0)
                    startFight.setDisable(false);
            }
        });

        startFight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.startFight(battleLog);
                startFight.setDisable(true);
                restart.setDisable(false);
            }
        });

        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.resetGame();
                battleLog.clear();
                teamOneSetup.clear();
                teamTwoSetup.clear();
                ObservableList<Hero> list = HeroDAO.getHeroList();
                teamOneSelector.setItems(list);
                teamTwoSelector.setItems(list);
                teamOneSelector.getSelectionModel().selectFirst();
                teamTwoSelector.getSelectionModel().selectFirst();
                addToTeam2.setDisable(false);
                addToTeam1.setDisable(false);
                restart.setDisable(true);
            }
        });

        GridPane teamSelector = new GridPane();
        teamSelector.setVgap(4);
        teamSelector.setHgap(4);
        teamSelector.setPadding(new Insets(5, 5, 5, 5));
        teamSelector.add(new Label("Team one: "), 0, 0);
        teamSelector.add(teamOneSelector, 1, 0);
        teamSelector.add(addToTeam1,2,0);
        teamSelector.add(new Label("Team two: "), 4,0);
        teamSelector.add(teamTwoSelector, 5, 0);
        teamSelector.add(addToTeam2,6,0);

        GridPane teamSetup = new GridPane();
        teamSetup.setVgap(4);
        teamSetup.setHgap(4);
        teamSetup.setPadding(new Insets(5, 5, 5, 5));
        teamSetup.add(teamOneSetup, 0, 0);
        teamSetup.add(teamTwoSetup, 1, 0);

        GridPane battleField = new GridPane();
        battleField.setVgap(4);
        battleField.setHgap(4);
        battleField.setPadding(new Insets(5, 5, 5, 5));

        VBox controls = new VBox(startFight, restart);
        battleField.add(controls,0,0);
        battleField.add(battleLog,1,0);

        GridPane mainGrid = new GridPane();
        mainGrid.add(teamSelector,0,0);
        mainGrid.add(teamSetup,0,1);
        mainGrid.add(battleField,0,2);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(mainGrid);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    Game initGame(){
        return new Game();
    }
}

