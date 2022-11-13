package com.maemresen.charcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MyCharacterCounterV1 extends Application {

    static boolean countAll;

    @Override
    public void start(Stage primaryStage) {

        //Stage
        Stage window = primaryStage;
        window.setTitle("Character Counter");
        int width = 285;
        int height = 155;
        window.setMinHeight(height);
        window.setMinWidth(width);
        window.setMaxHeight(height);
        window.setMaxWidth(width);

        //CheckBox
        CheckBox check = new CheckBox("Count Only Alphabetic Characters");
        
        check.setSelected(true);
        //File Chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*txt"));
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        //Butons
        //Open Button
        Button open = new Button("Chooese file");
        open.setMinSize(width / 5, height / 8);
        open.setOnAction(e -> {
            File f = fileChooser.showOpenDialog(window);
            if (f != null) {

                try {
                    countAll = !check.isSelected();
                    String text = "";
                    Scanner scan = new Scanner(f);
                    while (scan.hasNext()) {
                        text += scan.nextLine();
                    }
                    text = text.replaceAll("\\s", " ").toLowerCase();
                    showPieChart(text, f.getName());
                } catch (FileNotFoundException ex) {

                }
            }
        });

        //Add Button
        Button enterText = new Button("   Own Text   ");
        enterText.setMinSize(width / 5, height / 8);
        enterText.setOnAction(e -> {
            countAll = !check.isSelected();
            enterYourText();
        });

        //Labels
        Label infoChoose = new Label("Make Your Choice!");
        infoChoose.setFont(new Font(15));

        //Border Pane
        BorderPane infoPane = new BorderPane();
        infoPane.setPadding(new Insets(10, 0, 0, 0));
        infoPane.setCenter(infoChoose);

        BorderPane openPane = new BorderPane();
        openPane.setPadding(new Insets(10, 0, 0, 40));
        openPane.setCenter(open);

        BorderPane addPane = new BorderPane();
        addPane.setPadding(new Insets(10, 0, 0, 15));
        addPane.setCenter(enterText);

        BorderPane checkPane = new BorderPane();
        checkPane.setPadding(new Insets(15, 10, 0, 0));
        checkPane.setCenter(check);

        //HBox Buttons
        HBox buttons = new HBox();
        buttons.getChildren().addAll(openPane, addPane);

        //Vbox 
        VBox root = new VBox();
        root.getChildren().addAll(infoPane, buttons, checkPane);

        //Scene
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    //Show Pie Chart
    public static void showPieChart(String myText, String title) {

        //Stage
        Stage pieChartStage = new Stage();
        pieChartStage.setTitle(title);
        int width = 550;
        int height = 450;
        pieChartStage.setMinHeight(height);
        pieChartStage.setMinWidth(width);
        pieChartStage.setMaxHeight(height);
        pieChartStage.setMaxWidth(width);

        //Characters ListView
        ListView<String> charList = new ListView<>();
        charList.setMinWidth(85);
        charList.setMaxWidth(85);

        //Add Data To Piechart
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableList(new ArrayList<PieChart.Data>());
        TreeMap<Character, Integer> allChars = allCharacters(myText);
        int max = 0;
        char mostUsedChar = 'a';
        for (Map.Entry<Character, Integer> entry : allChars.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();
            pieChartData.add(new PieChart.Data(key + "", value));
            charList.getItems().add(key + " = " + value);
            if (value > max) {
                max = value;
                mostUsedChar = key;
            }
        }

        //Labels
        Label mostUsed = new Label();
        mostUsed.setText("The most used character is '" + mostUsedChar + "' with " + max + " times");
        mostUsed.setFont(new Font(20));
        mostUsed.setPadding(new Insets(10, 0, 0, 15));

        //PieChart 
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setLegendVisible(true);
        pieChart.setLegendSide(Side.RIGHT);
        pieChart.setPrefHeight(900);

        VBox labelAndChart = new VBox();
        labelAndChart.getChildren().addAll(mostUsed, pieChart);

        HBox root = new HBox();
        root.getChildren().addAll(charList, labelAndChart);

        Scene scene = new Scene(root);
        pieChartStage.setScene(scene);
        pieChartStage.show();

    }

    //Get Users Text
    public static void enterYourText() {

        TextArea myText = new TextArea("Enter Your Text");
        Stage textStage = new Stage();

        //Buttons
        Button count = new Button("count");
        count.setOnAction(e -> {
            showPieChart(myText.getText(), " Your Text");
            textStage.close();
        });

        //Border Panes
        BorderPane textPane = new BorderPane();
        textPane.setPadding(new Insets(10, 10, 0, 10));
        textPane.setCenter(myText);

        BorderPane countPane = new BorderPane();
        countPane.setPadding(new Insets(5, 0, 10, 0));
        countPane.setCenter(count);

        //VBox
        VBox root = new VBox();
        root.getChildren().addAll(textPane, countPane);

        Scene scene = new Scene(root);
        textStage.setScene(scene);
        textStage.show();

    }

    // Get Characters
    public static TreeMap<Character, Integer> allCharacters(String myText) {

        TreeMap<Character, Integer> c = new TreeMap<>();
        
        myText = myText.replaceAll("\\s", " ").toLowerCase();

        for (int i = 0; i < myText.length(); i++) {
            char charAt = myText.charAt(i);
            if (countAll || Character.isAlphabetic(charAt)) {
                if (c.containsKey(charAt)) {
                    c.put(charAt, c.get(charAt) + 1);
                } else {
                    c.put(charAt, 1);
                }
            }
        }
        return c;

    }

    public static void main(String[] args) {
        launch(args);
        
    }

}
