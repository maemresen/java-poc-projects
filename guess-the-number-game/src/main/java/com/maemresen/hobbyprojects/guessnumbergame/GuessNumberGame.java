package com.maemresen.hobbyprojects.guessnumbergame;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by maemr on 16.04.2016.
 */

public class GuessNumberGame {

    private static int num; // It's computers number.
    private static int samePos; // Shows how many digits have same position
    private static int diffPos; // Shows how many digits have different positions
    static int tryTime; // It count your predictions.
    static boolean isPlayAgain; //When game finished, it checks this

    /*---------------------------------------------------------
        * It generates a 4-digit number
     ---------------------------------------------------------*/
    public static int startGame() {

        boolean[] digits = new boolean[10];
        tryTime = 0;
        String yourNum = ""; // This will be your number.
        Random rand = new Random();

        /*---------------------------------------------------------
            * To create a 4-digit number
         ---------------------------------------------------------*/
        for (int i = 0; i < 4; i++) {
            int d = -1;

            /*---------------------------------------------------------
                * It checks whether used before
            ---------------------------------------------------------*/
            do{
                d = rand.nextInt(10);
            }while ((i == 0 && d == 0)|| digits[d]);

            digits[d] = true;
            yourNum += d + "";
        }
        num = Integer.parseInt(yourNum);
        System.out.println(num);
        return num;
    }

    public static VBox makeGuess(int n) {

        tryTime++;
        samePos = 0;
        diffPos = 0;
        String yourGuess = n + "";
        String realNum = num + "";
        for (int i = 0; i < yourGuess.length(); i++) {
            char c = yourGuess.charAt(i);
            if (yourGuess.indexOf(c) == realNum.indexOf(c)) {
                samePos++;
            } else if (realNum.indexOf(c) != -1) {
                diffPos++;
            }
        }


        /*---------------------------------------------------------
            * These are for show your progress
        ---------------------------------------------------------*/
        String msg1 = String.format("Your predict is %d\n",n);
        String msg2 = String.format("%d digit has same position\n",samePos);
        String msg3 = String.format("%d digit has different position",diffPos);

        Text t1 = new Text(msg1);
        t1.setFont(new Font("Verdana",16));
        t1.setFill(Color.BLUEVIOLET);
        t1.setTextAlignment(TextAlignment.CENTER);

        Text t2 = new Text(msg2);
        t2.setFont(new Font("Verdana",16));
        t2.setFill(Color.GREEN);
        t2.setTextAlignment(TextAlignment.CENTER);

        Text t3 = new Text(msg3);
        t3.setFont(new Font("Verdana",16));
        t3.setFill(Color.RED);
        t3.setTextAlignment(TextAlignment.CENTER);

        return new VBox(t1,t2,t3);

    }

    public static int getSamePos() {
        return samePos;
    }

    public static int getDiffPos() {
        return diffPos;
    }

    public static void setTryTime(int time){
        tryTime = time;
    }

    /*---------------------------------------------------------
        * You will see this window, when the game finished
    ---------------------------------------------------------*/
    public static void finishGame(){

        Stage endWindow = new Stage();
        endWindow.initModality(Modality.APPLICATION_MODAL);
        endWindow.initStyle(StageStyle.UNDECORATED);

        Label msg = new Label("Your score is "+tryTime);
        msg.setFont(new Font(25));
        msg.setTextFill(Color.GREEN);

        Label ans= new Label("Answer is "+num);
        ans.setFont(new Font(25));
        ans.setTextFill(Color.RED);


        VBox labels = new VBox(msg,ans);
        labels.setSpacing(20);

        Button playAgain = new Button("Play Again");
        playAgain.setOnAction(e -> {
            isPlayAgain = true;
            endWindow.close();
        });

        Button mainMenuBtn = new Button("Main Menu");
        mainMenuBtn.setOnAction(event ->{
            isPlayAgain = false;
            endWindow.close();
        });


        HBox buttons = new HBox(playAgain,mainMenuBtn);
        buttons.setSpacing(20);
        VBox vBox = new VBox(labels,buttons);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.getStylesheets().add("/sample/buttonStyle.css");

        Scene scene = new Scene(vBox);
        endWindow.setScene(scene);

        endWindow.showAndWait();
    }
}
