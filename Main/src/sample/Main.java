package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene startScene, kidScene, mainScene;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label welcome = new Label("Welcome to Alcorate!" );


        Label kidLabel = new Label("Go get an Ice cream instead");
        kidLabel.setAlignment(Pos.CENTER);

        //Button 1
        Button button1 = new Button("I am under the age of 20");
        button1.setOnAction(e ->window.setScene(kidScene));

        //Button 2
        Button button2 = new Button("I am over the age of 20");
        button2.setOnAction(e ->window.setScene(mainScene));

        //Start layout
        VBox startLayout = new VBox(20);
        startLayout.getChildren().addAll(button1, button2);
        startScene = new Scene(startLayout, 200, 200);

        //Kid layout
        VBox kidLayout = new VBox(20);
        kidLayout.getChildren().add(kidLabel);
        kidScene = new Scene(kidLayout, 300, 300);

        //Alcorate layout
        VBox mainLayout= new VBox(20);
        mainLayout.getChildren().add(welcome);
        mainScene = new Scene(mainLayout, 600, 600);
        startLayout.setAlignment(Pos.CENTER);

        window.setScene(startScene);
        window.setTitle("Project window");
        window.show();
    }
}
