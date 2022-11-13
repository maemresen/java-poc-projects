package com.maemresen.charcounter.stopwatch;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StopWatch {


    static long start, end;
    
    //Time
    public static void startTime() {
        start = System.nanoTime();
    }

    public static void stopTime() {
        long end = (System.nanoTime() - start);
        System.out.print("Elapsed time is: ");
        String elapsedTime;
        if (end / 1E9 >= 1) {
           elapsedTime=end / 1E9 + " seconds";
        } else if ((int) end / 1000000 > 0) {
            elapsedTime = (double) end / 1000000 + " miliseconds";
        } else {
            elapsedTime = end + " nanoseconds";
        }
        
        Stage window = new Stage();
        Label time = new Label(elapsedTime);
        time.setFont(new Font(15));
        StackPane root = new StackPane(time);
        Scene scene = new Scene(root,200,100);
        window.setScene(scene);
        window.showAndWait();
    }
}
