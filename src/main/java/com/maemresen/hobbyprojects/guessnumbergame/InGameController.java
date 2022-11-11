package com.maemresen.hobbyprojects.guessnumbergame;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class InGameController {


    private String usedDigits = ""; // It holds your digits
    private ToggleButton[] buttons; // All number buttons
    private String msg = "Your digits are = ";

    @FXML
    HBox btnHBox; // This contains all buttons for add digit to your predict

    @FXML
    Label usedDigitsLabel; // This label shows used digits

    @FXML
    Button makeGuessBtn; // This is for make your guess

    @FXML
    VBox rightVBox; // This contains your guess results

    @FXML
    ImageView soClose;

    public void initialize() {


        rightVBox.getChildren().clear();
        btnHBox.getChildren().clear();

        usedDigitsLabel.setText(msg);

        buttons = new ToggleButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new ToggleButton(i + "");
            buttons[i].setOnAction(e -> getDigit(e));
            btnHBox.getChildren().add(buttons[i]);
        }
        buttons[0].setDisable(true);

    }

    private void getDigit(Event e) {

        ToggleButton b = ((ToggleButton) e.getSource());
        buttons[0].setDisable(false);
        int d = Integer.parseInt(b.getText());
        if (!b.isSelected()) {
            usedDigits = removeChar(d);
            if (usedDigits.length() == 1) {
                if (usedDigits.charAt(0) == '0') {
                    usedDigits = "";
                    buttons[0].setSelected(false);
                    buttons[0].setDisable(true);
                }
            }
            if (usedDigits.length() == 0) {
                buttons[0].setDisable(true);
            }
            usedDigitsLabel.setText(msg + usedDigits);
            makeGuessBtn.setDisable(true);
        } else {
            if (usedDigits.length() < 4) {
                usedDigits += d + "";
                usedDigitsLabel.setText(msg + usedDigits);
                if (usedDigits.length() == 4) {
                    makeGuessBtn.setDisable(false);
                }
            } else {
                b.setSelected(false);
            }
        }

    }

    private String removeChar(int d) {

        int i = usedDigits.indexOf(d + "");
        String result = usedDigits.substring(0, i) + usedDigits.substring(i + 1);
        return result;
    }

    @FXML
    public void tryNumber() {

        soClose.setVisible(false);
        rightVBox.getChildren().addAll(
                GuessNumberGame.makeGuess(
                        Integer.parseInt(usedDigits)
                )
                , new Separator());

        int samePos = GuessNumberGame.getSamePos();
        if (samePos == 4) {
            GuessNumberGame.finishGame();
            if (GuessNumberGame.isPlayAgain) {
                GuessNumberGame.startGame();
                initialize();
            }else{
                Main.window.setScene(Main.mainMenu);
            }
        } else if (samePos > 2) {
            soClose.setVisible(true);
        }
        usedDigits = "";
        usedDigitsLabel.setText(msg);
        makeGuessBtn.setDisable(true);
        setSelected(false);
        buttons[0].setDisable(true);
    }

    private void setSelected(boolean status) {
        for (ToggleButton tb : buttons) {
            tb.setSelected(status);
        }
    }

    @FXML
    public void giveUp() {
        GuessNumberGame.setTryTime(0);
        GuessNumberGame.finishGame();
        if (GuessNumberGame.isPlayAgain) {
            GuessNumberGame.startGame();
            initialize();
        }else
            Main.window.setScene(Main.mainMenu);

    }
}
