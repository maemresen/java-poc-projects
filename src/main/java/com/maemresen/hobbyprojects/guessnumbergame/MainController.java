package com.maemresen.hobbyprojects.guessnumbergame;



import static com.maemresen.hobbyprojects.guessnumbergame.Main.inGameMenu;
import static com.maemresen.hobbyprojects.guessnumbergame.Main.window;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void playGame() throws IOException {

        window.setScene(inGameMenu);
        GuessNumberGame.startGame();
    }

    @FXML
    public void exitGame(){
        Platform.exit();
    }

}
