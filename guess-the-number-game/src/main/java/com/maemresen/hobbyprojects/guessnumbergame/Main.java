package com.maemresen.hobbyprojects.guessnumbergame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    static Stage window;

    static double xOffset;
    static double yOffset;

    static Scene mainMenu;

    static Scene inGameMenu;


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        mainMenu = new Scene(
                FXMLLoader.load(getClass().getResource("/mainMenu.fxml"))
        );

        inGameMenu = new Scene(
                FXMLLoader.load(getClass().getResource("/sample.fxml")),1100,300
        );

        move(mainMenu);
        move(inGameMenu);

        window.setTitle("Guess Number Game");
        window.initStyle(StageStyle.TRANSPARENT);

        window.setScene(mainMenu);
        window.show();

    }

    /*
        Method for move scene without border
     */
    public static void move(Scene scene) {

        scene.setOnMousePressed(e -> {
                xOffset = e.getSceneX();
                yOffset = e.getSceneY();
        });
        scene.setOnMouseDragged(e -> {
                window.setX(e.getScreenX() - xOffset);
                window.setY(e.getScreenY() - yOffset);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
