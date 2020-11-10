package com.maemresen.hobbyprojcts;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayNameCharacters extends Application {

    static String name = "eren", lastName = "sen";
    static int ni = 0, lni = 0;

    @Override
    public void start(Stage primaryStage) {

        Button nameButton = new Button(name.charAt(ni) + "");

        nameButton.setOnAction(e -> {

            //Check name is finished
            if (ni >= name.length() - 1) {
                display("OK", "You Finished Your Name!");
                Platform.exit();
            } else {
                ni++;
                //Set buttons text to next Char
                nameButton.setText(name.charAt(ni) + "");
                primaryStage.show();
            }

        });

        Button lastNameButton = new Button(lastName.charAt(lni) + "");

        lastNameButton.setOnAction(e -> {

            //Check last name is finished
            if (lni >= lastName.length() - 1) {
                display("OK", "You Finished Your Last Name!");
                Platform.exit();
            } else {
                lni++;
                //Set buttons text to next Char
                lastNameButton.setText(lastName.charAt(lni) + "");
                primaryStage.show();
            }

        });

        // To Add Buttons
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(nameButton, lastNameButton);


        Scene scene = new Scene(buttons, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void display(String title, String msg) {

        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        //Label
        Label message = new Label(msg);

        StackPane sp = new StackPane();
        sp.getChildren().add(message);
        Scene scene = new Scene(sp, 200, 60);
        window.setScene(scene);
        window.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
