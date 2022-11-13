package com.maemresen.charcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyCharacterCounterV2 extends Application {

    static Image icon = new Image("myIcon.png");
    static String myScene = "myScene.css";
    static ChoiceBox<String> readFiles;
    static boolean countAll = false;

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Stage
        Stage window = primaryStage;
        window.setTitle("Character Counter");
        window.getIcons().add(icon);

        int width = 320;
        int height = 130;
        window.setMinHeight(height);
        window.setMinWidth(width);
        window.setMaxHeight(height);
        window.setMaxWidth(width);

        //CheckBox
        CheckBox check = new CheckBox("Count Only Alphabetic Characters    ");
        check.setSelected(!countAll);
        check.selectedProperty().addListener((v, oldValue, newValue) -> {
            countAll = oldValue;
        });

        //Butons
        //Open File Button
        Button openFileButton = new Button("Open File");
        openFileButton.setTooltip(new Tooltip("Counts characters in the selected file"));
        openFileButton.setOnAction(e -> {
            File f = getFile(window);
            if (f != null) {
                try {
                    openFileButtonClick(f);
                } catch (IOException ex) {

                }
            }
        });

        //Folder Button
        Button openFolderButton = new Button("Open Folder");
        openFolderButton.setTooltip(new Tooltip("Counts characters in the selected folder"));
        openFolderButton.setOnAction(e -> {
            File[] f = getFolder(window, ".txt");
            try {
                openFolderButtonClick(f);
            } catch (IOException ex) {

            }
        });

        //Add Button
        Button enterTextButton = new Button("Enter Text");
        enterTextButton.setOnAction(e -> {

            showTextField();

        });
        enterTextButton.setTooltip(new Tooltip("Counts characters in the entered text"));

        //HBox Buttons
        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(openFileButton, openFolderButton, enterTextButton);

        //Vbox 
        VBox root = new VBox(15);
        root.setPadding(new Insets(0, 0, 0, 20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(check, buttons);

        //Scene
        Scene scene = new Scene(root);
        scene.getStylesheets().add(myScene);
        window.setScene(scene);
        window.show();

    }

    //Button Events
    public static void openFileButtonClick(File f) throws IOException {

        try {
            String text = fileToString(f);
            showStatistics(text, f.getName(), countWords(text), true);
        } catch (FileNotFoundException ex) {
        }

    }

    public static void openFolderButtonClick(File[] f) throws IOException {

        if (f != null) {
            String text = folderToString(f);
            showStatistics(text, "files", countWords(text), true);
        }

    }

    // Get All Text Files From A folder
    public static File[] getFolder(Stage window, String tag) {

        //Directory Chooser
        DirectoryChooser dc = new DirectoryChooser();
        dc.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File folder = dc.showDialog(window);
        if (folder == null) {
            return null;
        }
        //add Filter To Get Files
        FileFilter ff = (File file) -> file.getName().endsWith(tag);

        File[] files = folder.listFiles(ff);
        readFiles = new ChoiceBox<>();

        for (File file : files) {
            readFiles.getItems().add(file.getName());
        }
        return files;
    }

    //Get File From a Folder
    public static File getFile(Stage window) {

        //File Chooser
        FileChooser fc = new FileChooser();
        fc.setTitle("Open Resource File");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*txt"));
        fc.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File f = fc.showOpenDialog(window);
        if (f != null) {
            readFiles = new ChoiceBox<>();
            readFiles.getItems().add(f.getName());
        }
        return f;

    }

    //Put each the text of the each file to one String
    public static String folderToString(File[] folder) throws IOException {

        String text = "";

        for (File f1 : folder) {
            try {
                text += fileToString(f1);

            } catch (FileNotFoundException ex) {
            }

        }

        return text;
    }

    //For convert text file to string.
    public static String fileToString(File f) throws FileNotFoundException, IOException {

        if (f == null) {
            return "";
        }

        BufferedReader br = new BufferedReader(new FileReader(f));
        String text = "";
        
        while (true) {
            String x = br.readLine();
            if(x == null)
                break;
            text += x;
        }
        br.close();
        return text;

    }

    //To Enter Your Own Text
    public static void showTextField() {

        TextArea myText = new TextArea();
        //Buttons
        Button count = new Button("Count");
        count.setOnAction(e -> {
            String text = myText.getText();
            showStatistics(text, "My Text", countWords(text), false);
        });

        //Initialize Stage
        Stage textStage = new Stage();
        textStage.getIcons().add(icon);
        textStage.setTitle("Enter Your Text");

        //Layout
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(myText, count);

        //Scene and Show
        Scene scene = new Scene(root);
        scene.getStylesheets().add(myScene);
        textStage.setScene(scene);
        textStage.show();

    }

    // To Count Words in the given String 
    public static int countWords(String text) {

        String[] words = text.split("\\s");
        int count = 0;
        for (String word : words) {
            if (word.length() > 0) {
                count++;
            }
        }
        return count;
    }

    // To Count Characters in the given String
    public static TreeMap<Character, Integer> getCharacters(String myText) {

        TreeMap<Character, Integer> myChars = new TreeMap<>();
        myText = myText.replace("\\s", " ").toLowerCase();
        for (int i = 0; i < myText.length(); i++) {
            char c = myText.charAt(i);
            if (countAll || Character.isAlphabetic(c)) {
                if (!myChars.containsKey(c)) {
                    myChars.put(c, 1);
                } else {
                    myChars.put(c, myChars.get(c) + 1);
                }
            }
        }
        return myChars;

    }

    //Show Characters On Pie Chart
    public static void showStatistics(String myText, String title, int howManyWords, boolean showReadFile) {

        Stage window = new Stage();
        window.setTitle(title);
        int width = 550;
        int height = 450;
        window.setMinHeight(height);
        window.setMinWidth(width);
        window.setMaxHeight(height);
        window.setMaxWidth(width);
        window.getIcons().add(icon);
        //Characters On ListView
        ListView<String> charList = new ListView<>();
        charList.setMinWidth(100);
        charList.setMaxWidth(100);

        //Add data to Piechart
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableList(new ArrayList<PieChart.Data>());
        TreeMap<Character, Integer> allChars = getCharacters(myText);
        int max = 0;
        int howManyChar = 0;
        char mostUsedChar = 'a';
        for (Map.Entry<Character, Integer> entry : allChars.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            pieChartData.add(new PieChart.Data(key + "", value));
            charList.getItems().add(key + " = " + value);
            howManyChar += value;
            //To find the most commonly used characters
            if (value > max) {
                max = value;
                mostUsedChar = key;
            }
        }

        //Labels
        Label mostUsed = new Label();
        mostUsed.setText("The most used char is '" + mostUsedChar + "' with " + divDigits(max) + " times");
        mostUsed.setFont(new Font(20));
        String msg = "Your text has " + divDigits(howManyWords) + " word";
        if (howManyWords > 1) {
            msg += "s";
        }
        String msg2 = "" + divDigits(howManyChar) + " char";
        if (howManyChar > 1) {
            msg2 += "s";
        }

        Label howManyWordL = new Label(msg);
        howManyWordL.setFont(new Font(20));

        Label howManyWordC = new Label(msg2);
        howManyWordC.setFont(new Font(20));

        //Initialize PieChart
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setLegendVisible(false);
        pieChart.setPrefHeight(900);

        //Labels And PieChart
        VBox labelAndChart = new VBox();
        labelAndChart.setAlignment(Pos.CENTER);
        labelAndChart.getChildren().addAll(mostUsed, howManyWordL, howManyWordC, pieChart);

        //ListView And VBox
        HBox statictics = new HBox();
        statictics.getChildren().addAll(charList, labelAndChart);

        VBox root = new VBox(10);
        root.getChildren().add(statictics);
        if (showReadFile) {
            HBox labelAndReadFiles = new HBox(10);
            Label label = new Label("Read Files");
            label.setPadding(new Insets(5, 0, 0, 0));
            label.setFont(new Font(18));
            labelAndReadFiles.getChildren().addAll(label, readFiles);
            root.getChildren().add(labelAndReadFiles);
        }
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(myScene);
        window.setScene(scene);
        window.show();

    }

    // To show digits
    public static String divDigits(int n) {

        String number = n + "";
        int d = number.length() % 3;
        String result = "";
        for (int i = 0; i < number.length(); i++) {
            if (i > 0 && i% 3 == d) {
                result += ".";
            }
            result += number.charAt(i) + "";

        }
        return result;
    }
    
    public static void main(String[] args) {
        launch(args);

    }

}
